package com.lh.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import com.lh.pojo.Major;
import com.lh.pojo.PageBean;
import com.lh.service.MajorService;
import com.lh.utils.DateJsonValueProcessor;
import com.lh.utils.ResponseUtil;
import com.lh.utils.ResultData;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import net.sf.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by laiHom on 2019/8/20.
 */
@Controller
@RequestMapping("/major")
@Slf4j
public class MajorController {
    @Autowired
    MajorService majorService;

    //页面列表展示
    @RequestMapping("/majorList")
    public String firstList(@RequestParam(value = "page", required = false) String page,
                            @RequestParam(value = "rows", required = false) String rows,
                            HttpServletResponse response) throws Exception {
        PageBean pageBean = new PageBean(Integer.parseInt(page),
                Integer.parseInt(rows));
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        List<Major> majorList = majorService.list(map);
        Long total = majorService.getTotal(map);
        System.out.println("每次都进来统计一下吗？"+page+"和"+rows);
        JSONObject result = new JSONObject();
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor());
        JSONArray jsonArray = JSONArray.fromObject(majorList,jsonConfig);
        result.put("rows", jsonArray);
        result.put("total", total);
        ResponseUtil.write(response, result);
        return null;
    }

    //新增或修改
    @RequestMapping("/save")
    public String addMajor(Major major,HttpServletResponse response,HttpServletRequest request) throws Exception {
        int resultTotal=0; // 操作的记录条数
        major.setUpdateTime(new Date());
        major.setPersonName((String) request.getSession().getAttribute("userName"));
        if(major.getMajorId()==null) {
            resultTotal = majorService.addMajor(major);
        }else {
            resultTotal = majorService.updateMajor(major);
        }
        JSONObject result=new JSONObject();
        if(resultTotal>0){
            result.put("success", true);
        }else{
            result.put("false", false);
        }
        ResponseUtil.write(response, result);
        return null;
    }

    //删除
    @RequestMapping("/delete")
    public String delete(@RequestParam("ids") String ids, HttpServletResponse response) throws Exception {
        String idsStr[] = ids.split(",");
        JSONObject result = new JSONObject();

        majorService.delete(idsStr);

        result.put("success", true);
        ResponseUtil.write(response, result);
        return null;


    }

    @RequestMapping("/getAll")
    @ResponseBody

        public ResultData<List<Major>> getAll() throws Exception {
            List<Major> banners = majorService.getAll();
            ResultData<List<Major>> resultData = new ResultData<>();
            resultData.setData(banners);
            resultData.setCode("0");
            return resultData;

    }


    @RequestMapping("/importExcel")
    public String importExcel2(@RequestParam("files") MultipartFile file,HttpServletRequest request,HttpServletResponse response) {
        // 带结果到页面
        JSONObject jsonResult = new JSONObject();

        ImportParams importParams = new ImportParams();
        // 数据处理
        importParams.setHeadRows(1);
        importParams.setTitleRows(1);
        // 需要验证
        importParams.setNeedVerfiy(true);
        String[] str = {"xls","xlsx"};
        importParams.setImportFields(str);
        int res = 0;
        try {
            ExcelImportResult<Major> result = ExcelImportUtil.importExcelMore(file.getInputStream(), Major.class,
                    importParams);
            List<Major> majorList = result.getList();
            res = majorService.inputAll(majorList, request);
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
        List<Major> addresses = majorService.findAll();
        // 设置响应输出的头类型(设置响应类型)
        response.setHeader("content-Type", "application/vnd.ms-excel");
        // 下载文件的默认名称(设置下载文件的默认名称)
        response.setHeader("Content-Disposition", "attachment;filename=major.xls");
        //导出操作
        try {
            Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("专业信息","1"),Major.class,addresses);
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
