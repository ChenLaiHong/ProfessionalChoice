package com.lh.controller;

import com.lh.pojo.Notice;
import com.lh.service.NoticeService;
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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * Created by laiHom on 2019/8/20.
 */
@Controller
public class PageController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private NoticeService noticeService;


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

    @RequestMapping("/toMajor")
    public String toMajor(){
        return "/admin/majorPage";
    }

    @RequestMapping("/toNotice")
    public String toNotice(){
        return "/admin/noticePage";
//        return "/admin/search";f
    }
    //登陆操作
    @PostMapping("/login")
    public ModelAndView login(HttpServletRequest request, Integer person, Map<String,Object> map, ModelAndView mv, Model model) {
        String name = request.getParameter("adminName");
        String password = request.getParameter("adminPassword");
        //获取subject
        Subject subject = SecurityUtils.getSubject();
        //封装用户信息
        UsernamePasswordToken token = new UsernamePasswordToken(name, MdUtil.md5(password));

        mv.setViewName("index");
        try {
            subject.login(token);

        }catch (UnknownAccountException e){
            //登陆用户名不存在
            map.put("msg", "用户不存在!");

        }catch (IncorrectCredentialsException e){
            //登陆失败，密码错误
            map.put("msg", "密码错误!");

        }
        //登陆成功
        HttpSession session=request.getSession();//获取session并将userName存入session对象
        session.setAttribute("userName", name);
        List<Notice> list = noticeService.getAll();
        model.addAttribute("noticeInfo", list);
        if(person == 4){
            mv.setViewName("/admin/AdminMain");
        }else if (person == 1){
            mv.setViewName("/student/studentMain");
        }
        return mv;

    }

}
