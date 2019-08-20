package com.lh.controller;

import com.lh.pojo.Admin;
import com.lh.service.StudentService;
import com.lh.utils.Result;
import com.lh.utils.ResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
    @RequestMapping("/main")
    public String main(){
        return "main";
    }

    //登陆操作
    @PostMapping("/login")
    public String login(HttpServletRequest request, Integer person,Map<String,Object> map){
        String name = request.getParameter("adminName");
        String password = request.getParameter("adminPassword");
        //当登陆用户是学生
        if(person.equals(1)){

        }
        System.out.println(person+"是多少");
        map.put("msg", "密码或账号错误!");
        return "index";
    }

}
