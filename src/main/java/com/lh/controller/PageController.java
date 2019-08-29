package com.lh.controller;

import com.lh.pojo.Notice;
import com.lh.service.NoticeService;
import com.lh.service.StudentService;
import com.lh.utils.MdUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
        return "/admin/noticeManage";
    }

    @RequestMapping("/toStudent")
    public String toStudent(){
        return "/admin/studentManage";
    }

    @RequestMapping("/toMajor")
    public String toMajor(){
        return "/admin/majorManage";
    }
    //
    @RequestMapping("/toGrade")
    public String toGrade(){
        return "/admin/gradeManage";
    }

    //
    @RequestMapping("/toDepartment")
    public String toDepartment(){
        return "/admin/departmentManage";
    }

    @RequestMapping("/toNotice")
    public String toNotice(){
        return "/admin/noticeManage";
    }

    //
    @RequestMapping("/toRole")
    public String toRole(){
        return "/admin/roleManage";
//        return "/admin/roles";
    }
    //
    @RequestMapping("/toTeacher")
    public String toTeacher(){
        return "/admin/teacherManage";
    }
    //登陆操作
    @PostMapping("/login")
    public String login(HttpServletRequest request, Map<String,Object> map,Model model) {
        String name = request.getParameter("adminName");
        String password = request.getParameter("adminPassword");
        //获取subject
        Subject subject = SecurityUtils.getSubject();
        //封装用户信息
        UsernamePasswordToken token = new UsernamePasswordToken(name, MdUtil.md5(password));

        try {
            subject.login(token);
            //登陆成功

            HttpSession session=request.getSession();//获取session并将userName存入session对象
            session.setAttribute("userName", name);
            List<Notice> list = noticeService.getAll();
            model.addAttribute("noticeInfo", list);
            return "/admin/AdminMain";

        }catch (UnknownAccountException e){
            //登陆用户名不存在
            map.put("msg", "用户不存在!");

        }catch (IncorrectCredentialsException e){
            //登陆失败，密码错误
            map.put("msg", "密码错误!");
        }
        return "index";

    }



}
