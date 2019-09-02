package com.lh.interceptor;

import com.alibaba.fastjson.JSON;
import com.lh.pojo.Person;
import com.lh.service.StudentService;
import com.lh.utils.RedisKey;
import com.lh.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * <p>Description: 用与学生选报任务模块拦截用户信息，获取数据</p>
 *
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private RequestHolder requestHolder;

    @Autowired
    private StudentService studentService;

    @Autowired
    private RedisUtil redisUtil;

    /**
     * 请求开始前执行
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取session
        HttpSession session = request.getSession();
        // 获取用户id
        String userId = (String) session.getAttribute("id");
        // Redis查找用户的数据
        String userJson = (String) redisUtil.hget(RedisKey.USER, userId);
        Person person;
        // Redis存在用户数据，将json转成Person对象
        if (userJson != null) {
           person = JSON.parseObject(userJson, Person.class);
        } else {
            // redis无数据则从数据库查
            person = studentService.findById(userId);
            // 放入redis,存放3个小时
            redisUtil.hset(RedisKey.USER, person.getLoginId(), JSON.toJSONString(person), 10800);
        }
        // 放入线程缓存中，方便后面的处理过程获取数据
        requestHolder.setPerson(person);
        // 通过拦截器
        return true;
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 返回数据完毕，清理ThreadLocal对应的缓存
        requestHolder.clear();
    }
}
