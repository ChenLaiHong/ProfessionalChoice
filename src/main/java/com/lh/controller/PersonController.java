package com.lh.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lh.pojo.*;
import com.lh.service.GradeService;
import com.lh.service.ImageService;
import com.lh.service.MajorService;
import com.lh.service.StudentService;

import com.lh.utils.DateUtil;
import com.lh.utils.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.lh.utils.FileUploadUtil.*;

/**
 * Created by laiHom on 2019/8/31.
 */
@Controller
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private ImageService imageService;
    @Autowired
    private GradeService gradeService;
    @Autowired
    private MajorService majorService;

    @RequestMapping("/toInfo")
    public ModelAndView toInfo(HttpServletRequest request){
        Person person = studentService.findById((String) request.getSession().getAttribute("id"));
        Image image = imageService.findById((String) request.getSession().getAttribute("id"));
        String personPhoto = "/upload/imgs/";
        if(image != null){
            personPhoto += image.getPersonPhoto();
        }

        ModelAndView mav = new ModelAndView();
        List<Major> majorList = majorService.getAll();
        List<Grade> gradeList = gradeService.getAll();
        mav.addObject("majorList", majorList);
        mav.addObject("gradeList", gradeList);
        mav.addObject("person", person);
        mav.addObject("personPhoto",personPhoto );
        mav.setViewName("/person/studentInfo");
        return mav;
    }

//

    @RequestMapping("/saveInfo")
    public String list(Person person,@RequestParam("personPhoto") MultipartFile file, HttpServletRequest request) throws Exception {
        if (!file.isEmpty()) {

            String imageName = DateUtil.getCurrentDateStr() + "."
                    + file.getOriginalFilename().split("\\.")[1];
            // 存放上传图片的文件夹
            File fileDir = getImgDirFile();
            // 构建真实的文件路径
            File newFile = new File(fileDir.getAbsolutePath() + File.separator + imageName);
            System.out.println(newFile.getAbsolutePath()+"**********************");
            file.transferTo(newFile);
            Image image = new Image();
            Image result = imageService.findById(person.getLoginId());
            if(result == null){

                image.setPersonId(person.getLoginId());
                image.setPersonPhoto(imageName);
                imageService.inster(image);
            }else {
                imageService.update(image);
            }
        }
        studentService.update(person);

        return "redirect:/person/toInfo";
    }



}
