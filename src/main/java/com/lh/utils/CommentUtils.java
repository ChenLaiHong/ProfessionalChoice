package com.lh.utils;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import com.lh.pojo.Notice;
import com.lh.pojo.PageBean;
import com.lh.pojo.Person;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

/**
 * Created by laiHom on 2019/8/23.
 */
public class CommentUtils {
    public static Map<String, Object> findListFirst(String page,String rows){

        PageBean pageBean = new PageBean(Integer.parseInt(page),
                Integer.parseInt(rows));
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        return map;
    }
    public static Map<String, Object> findListFirst(String page,String rows,String keyWords,String factor){

        PageBean pageBean = new PageBean(Integer.parseInt(page),
                Integer.parseInt(rows));
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        map.put("keyWords", keyWords);
        map.put("factor", factor);
        return map;
    }
    public static JSONObject findListSecond(List<Objects> list, Long total){

        JSONObject result = new JSONObject();
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor());
        JSONArray jsonArray = JSONArray.fromObject(list,jsonConfig);
        result.put("rows", jsonArray);
        result.put("total", total);
        return result;
    }
    public static JSONObject findListSecond(List<Notice> list, Long total,String s){

        JSONObject result = new JSONObject();
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor());
        JSONArray jsonArray = JSONArray.fromObject(list,jsonConfig);
        result.put("rows", jsonArray);
        result.put("total", total);
        return result;
    }

    public static List StringIds(String[] ids){
        List ints = new ArrayList();
        for(int i =0;i<ids.length;i++){
            ints.add(Integer.parseInt(ids[i]));
        }
        return ints;
    }

    public static List<Object> importExcel(MultipartFile file,Object object) throws Exception {


        ImportParams importParams = new ImportParams();
        // 数据处理
        importParams.setHeadRows(1);
        importParams.setTitleRows(1);
        // 需要验证
        importParams.setNeedVerfiy(true);
        String[] str = {"xls","xlsx"};
        importParams.setImportFields(str);
        ExcelImportResult<Object> result = ExcelImportUtil.importExcelMore(file.getInputStream(), Object.class,
                importParams);
        List<Object> lists = result.getList();
        return lists;
    }

}
