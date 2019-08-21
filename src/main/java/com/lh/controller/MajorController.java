package com.lh.controller;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import com.lh.pojo.Major;
import com.lh.service.MajorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

/**
 * Created by laiHom on 2019/8/20.
 */
@Controller
@RequestMapping("/major")
@Slf4j
public class MajorController {
    @Autowired
    MajorService majorService;

    @RequestMapping("/get")
    @ResponseBody
    public Major getMajor(@RequestParam(name = "majorId") Integer id){
        Major major = majorService.getMajorById(id);
        return major;
    }

    @PostMapping("/importExcel")
    @ResponseBody
    public String importExcel2(@RequestParam("files") MultipartFile file) throws Exception {
        ImportParams importParams = new ImportParams();
        // 数据处理
        importParams.setHeadRows(1);
        importParams.setTitleRows(1);
        // 需要验证
        importParams.setNeedVerfiy(false);

        ExcelImportResult<Major> result = ExcelImportUtil.importExcelMore(file.getInputStream(), Major.class,
                importParams);
        List<Major> majorList = result.getList();
        int result2 = majorService.inputAll(majorList);
        System.out.println(result2+"********************");
        if(result2 > 0){
            return "导入成功";
        }
        return "导入失败";
    }

}
