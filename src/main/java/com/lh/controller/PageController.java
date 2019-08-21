package com.lh.controller;

import com.lh.pojo.Admin;
import com.lh.service.AdminService;
import com.lh.service.StudentService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
    @Autowired
    private AdminService adminService;

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

        //当登陆用户是管理员
        if (person.equals(3)) {
            Admin admin = adminService.login(name, password);
            if (admin == null) {
                map.put("msg", "密码或账号错误!");
                return "index";
            }
            request.getSession().setAttribute("adminInfo", admin);

            return "/admin/AdminMain";
        } else if (person.equals(1)) {

        }
        System.out.println(person + "是多少");
        // map.put("msg", "密码或账号错误!");
        return "index";


    }

}
