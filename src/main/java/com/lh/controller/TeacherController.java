package com.lh.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lh.pojo.*;
import com.lh.service.*;
import com.lh.utils.MdUtil;
import com.lh.utils.ResponseUtil;
import com.lh.utils.StringUtil;
import net.sf.json.JSONObject;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.lh.utils.CommentUtils.res;


/**
 * Created by laiHom on 2019/8/20.
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private RoleService roleService;

    ////////////////////////////
    @RequestMapping("/list")
    public String list(@RequestParam(value = "page", required = false) String page,
                       @RequestParam(value = "limit", required = false) String rows,
                       @RequestParam(value = "q", required = false) String q,
                       HttpServletResponse response) throws Exception {
        PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        map.put("q", StringUtil.formatLike(q));

        List<Person> list = teacherService.listT(map);
        Integer total = teacherService.getTotalT(map);
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

        map.clear();
        map.put("data", list);
        map.put("count", total);
        map.put("code", 0);
        map.put("msg", "");
        ResponseUtil.write(response, gson.toJson(map));
        return null;
    }




    @RequestMapping("/toAdd")
    public ModelAndView toAdd() throws Exception {

        ModelAndView mav = new ModelAndView();
        List<Role> roleList = roleService.getAll();
        mav.addObject("roleList", roleList);
        mav.addObject("btn_text", "添加");
        mav.addObject("save_url", "/teacher/add");
        mav.setViewName("/admin/teacherAddOrUpdate");
        return mav;
    }

    @RequestMapping("/add")
    public String add(Person person, HttpServletResponse response, HttpServletRequest request) throws Exception {

        person.setPassword(MdUtil.md5("123456"));
        int resultTotal = teacherService.add(person);
        Gson gson = new Gson();
        ResponseUtil.write(response, gson.toJson(res(resultTotal)));
        return null;
    }

    @RequestMapping("/toEdit")
    public ModelAndView toEdit(@RequestParam(value="loginId",required=false)String loginId) throws Exception {

        ModelAndView mav = selectInfo(loginId);
        mav.addObject("btn_text", "修改");
        mav.addObject("save_url", "/teacher/update?loginId="+loginId);
        mav.setViewName("/admin/teacherAddOrUpdate");
        return mav;
    }

    @RequestMapping("/showAll")
    public ModelAndView showAll(@RequestParam(value="loginId",required=false)String loginId) throws Exception {

        ModelAndView mav = selectInfo(loginId);
        mav.addObject("btn_text", "所有信息");
        mav.setViewName("/admin/teacherShowAllInfo");
        return mav;
    }

    @RequestMapping("/update")
    public String update(Person person, HttpServletResponse response, HttpServletRequest request) throws Exception {

        int resultTotal = teacherService.update(person);
        Gson gson = new Gson();
        ResponseUtil.write(response, gson.toJson(res(resultTotal)));
        return null;
    }
    //更新状态setState
    @RequestMapping("/setState")
    public String setState(@RequestParam(value = "loginId", required = false) String loginId, HttpServletResponse response)
            throws Exception {
        Gson gson = new Gson();
        Result result = new Result();
        Person person = studentService.findById(loginId);
        if (person.getStudentStatus() == 0) {
            person.setStudentStatus(1);
        } else {
            person.setStudentStatus(0);
        }
        teacherService.update(person);
        result.setSuccess(true);
        ResponseUtil.write(response, gson.toJson(result));
        return null;
    }

    //打开上传窗口toImport
    @RequestMapping("/toImport")
    public ModelAndView toImport() throws Exception {
        List<Role> roleList = roleService.getAll();
        ModelAndView mav = new ModelAndView();
        mav.addObject("roleList", roleList);
        mav.setViewName("/admin/teacherImportExcel");
        return mav;
    }

    @RequestMapping("/importExcel")
    public String importExcel2(@RequestParam("files") MultipartFile file, @RequestParam(value = "roleId") Integer roleId, @RequestParam(value = "gradeId") Integer gradeId, HttpServletResponse response) {
        // 带结果到页面
        JSONObject jsonResult = new JSONObject();
        ImportParams importParams = new ImportParams();
        // 数据处理
        importParams.setHeadRows(1);
        importParams.setTitleRows(1);
        // 需要验证
        importParams.setNeedVerfiy(false);


        int res = 0;
        try {
            ExcelImportResult<Person> result = ExcelImportUtil.importExcelMore(file.getInputStream(), Person.class,
                    importParams);
            List<Person> personList = result.getList();

                Map<String, Object> map = new HashMap<>();
                map.put("roleId", roleId);
                map.put("personList", personList);
                map.put("password", MdUtil.md5("123456"));
                res = teacherService.inputAll(map);


        }catch (InvalidFormatException e){
            jsonResult.put("status", "fail");
            jsonResult.put("message", "批量导入失败！文件格式不正确");
        }catch (Exception e){
            jsonResult.put("status", "fail");
            jsonResult.put("message", "批量导入失败！检查是否学号重复");
        }

        if(res>0){
            jsonResult.put("status", "ok");
            jsonResult.put("message", "批量导入成功！");
        }
        try {
            ResponseUtil.write(response, jsonResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    //导出信息
    @RequestMapping("/exportExcel")
    public void exportExcel(HttpServletResponse response) throws UnsupportedEncodingException {

        List<Teacher> teachers = teacherService.getAll();
        // 设置响应输出的头类型(设置响应类型)
        String fileName = "教职工信息";
        response.setHeader("content-Type", "application/vnd.ms-excel");
        // 下载文件的默认名称(设置下载文件的默认名称)
        response.setHeader("Content-disposition", "attachment;filename="+new String(fileName.getBytes("utf-8"), "iso8859-1")+".xls");
        //导出操作
        try {
            Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("教职工信息","1"),Person.class,teachers);
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //导出模板
    @RequestMapping("/exportExcelTel")
    public void export(HttpServletResponse response) throws UnsupportedEncodingException {

        List<Teacher> studentTel = teacherService.getTeacherTel();
        // 设置响应输出的头类型(设置响应类型)
        String fileName = "教职工信息模板";
        response.setCharacterEncoding("utf-8");
        response.setHeader("content-Type", "application/vnd.ms-excel");
        // 下载文件的默认名称(设置下载文件的默认名称)
        response.setHeader("Content-disposition", "attachment;filename="+new String(fileName.getBytes("utf-8"), "iso8859-1")+".xls");
        //导出操作
        try {
            Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("教职工信息(注：工号必填，其他列可删减)","1"),Person.class,studentTel);
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //编辑与查看全部信息
    public  ModelAndView selectInfo(String id){
        List<Role> roleList = roleService.getAll();
        ModelAndView mav = new ModelAndView();
        Person person = studentService.findById(id);
        mav.addObject("person", person);
        mav.addObject("roleList", roleList);
        return mav;
    }

}
