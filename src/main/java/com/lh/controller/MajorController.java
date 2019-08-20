package com.lh.controller;

import com.lh.pojo.Major;
import com.lh.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by laiHom on 2019/8/20.
 */
@Controller
@RequestMapping("/major")
public class MajorController {
    @Autowired
    MajorService majorService;

    @RequestMapping("/get")
    @ResponseBody
    public Major getMajor(@RequestParam(name = "majorId") Integer id){
        Major major = majorService.getMajorById(id);
        return major;
    }


}
