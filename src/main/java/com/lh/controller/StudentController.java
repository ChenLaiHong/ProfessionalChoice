package com.lh.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import com.lh.pojo.Person;
import com.lh.service.StudentService;
import com.lh.utils.ResponseUtil;
import net.sf.json.JSONObject;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


/**
 * Created by laiHom on 2019/8/20.
 */
@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/importExcel")
    public String importExcel2(@RequestParam("files") MultipartFile file, @RequestParam("majorId") Integer majorId, HttpServletResponse response) {
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

            System.out.println(file.getInputStream());
            ExcelImportResult<Person> result = ExcelImportUtil.importExcelMore(file.getInputStream(), Person.class,
                    importParams);
            List<Person> lists = result.getList();

            System.out.println(lists.get(1));
            res = studentService.inputAll(lists,majorId);
        }catch (InvalidFormatException e){
            jsonResult.put("status", "fail");
            jsonResult.put("message", "批量导入失败！文件格式不正确");
        }catch (Exception e){
            jsonResult.put("status", "fail");
            jsonResult.put("message", "批量导入失败！");
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

    //导出
    @RequestMapping("/exportExcel")
    public void export(HttpServletResponse response){
        List<Person> addresses = studentService.findAll();
        // 设置响应输出的头类型(设置响应类型)
        response.setHeader("content-Type", "application/vnd.ms-excel");
        // 下载文件的默认名称(设置下载文件的默认名称)
        response.setHeader("Content-Disposition", "attachment;filename=major.xls");
        //导出操作
        try {
            Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("专业信息","1"),Person.class,addresses);
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
