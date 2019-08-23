package com.lh.utils;

import com.lh.pojo.Notice;
import com.lh.pojo.PageBean;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

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
    public static JSONObject findListSecond(List<Objects> list, Long total){

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

}
