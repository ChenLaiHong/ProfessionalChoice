package com.lh.controller;

import com.lh.pojo.Major;
import com.lh.pojo.Notice;
import com.lh.pojo.PageBean;
import com.lh.service.NoticeService;
import com.lh.utils.DateJsonValueProcessor;
import com.lh.utils.ResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

import static com.lh.utils.CommentUtils.findListFirst;
import static com.lh.utils.CommentUtils.findListSecond;

/**
 * Created by laiHom on 2019/8/23.
 */
@Controller
@RequestMapping("/notice")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;
    //页面列表展示
    @RequestMapping("/noticeList")
    public String firstList(@RequestParam(value = "page", required = false) String page,
                            @RequestParam(value = "rows", required = false) String rows,
                            HttpServletResponse response) throws Exception {

        List<Objects> majorList = noticeService.list(findListFirst(page,rows));
        Long total = noticeService.getTotal(findListFirst(page,rows));
        ResponseUtil.write(response, findListSecond(majorList,total));
        return null;
    }

    //新增或修改
    @RequestMapping("/save")
    public String addMajor(Notice notice, HttpServletResponse response, HttpServletRequest request) throws Exception {
        int resultTotal=0; // 操作的记录条数
        notice.setNoticeTime(new Date());
        notice.setNoticePerson((String) request.getSession().getAttribute("userName"));
        if(notice.getNoticeId()==null) {
            resultTotal = noticeService.addNotice(notice);
        }else {
            resultTotal = noticeService.updateNotice(notice);
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

        noticeService.delete(idsStr);
        JSONObject result = new JSONObject();
        result.put("success", true);
        ResponseUtil.write(response, result);
        return null;
    }

    //搜索
    @RequestMapping("/search")
    public String search(@RequestParam("name") String factor,@RequestParam("keyWords") String keyWords,
                         @RequestParam(value = "page", required = false) String page,
                         @RequestParam(value = "rows", required = false) String rows,
                         HttpServletResponse response){


        System.out.println(factor);
        return null;
    }
}
