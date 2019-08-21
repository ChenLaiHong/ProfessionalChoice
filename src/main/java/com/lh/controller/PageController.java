package com.lh.controller;

import com.lh.service.StudentService;
import com.lh.utils.MdUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by laiHom on 2019/8/20.
 */
@Controller
public class PageController {

    @Autowired
    private StudentService studentService;


    //访问登陆页面
    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    //登陆成功后访问的首页
    @RequestMapping("/major")
    public String major(){
        return "major";
    }

    @RequestMapping("/main")
    public String main(){
        return "main";
    }

    @RequestMapping("/toStudent")
    public String toStudent(){
        return "student";
    }
    //登陆操作
    @PostMapping("/login")
    public String login(HttpServletRequest request, Integer person,Map<String,Object> map) {
        String name = request.getParameter("adminName");
        String password = request.getParameter("adminPassword");
        //获取subject
        Subject subject = SecurityUtils.getSubject();
        //封装用户信息
        UsernamePasswordToken token = new UsernamePasswordToken(name, MdUtil.md5(password));

        try {
            subject.login(token);

        }catch (UnknownAccountException e){
            //登陆用户名不存在
            map.put("msg", "用户不存在!");
            return "index";
        }catch (IncorrectCredentialsException e){
            //登陆失败，密码错误
            map.put("msg", "密码错误!");
            return "index";
        }
        //登陆成功

        return "/admin/AdminMain";




    }

}
