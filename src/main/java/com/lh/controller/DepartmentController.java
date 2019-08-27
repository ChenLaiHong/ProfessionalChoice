package com.lh.controller;

import com.google.gson.Gson;
import com.lh.pojo.Department;
import com.lh.pojo.Grade;
import com.lh.pojo.PageBean;
import com.lh.pojo.Result;
import com.lh.service.DepartmentService;
import com.lh.utils.ResponseUtil;
import com.lh.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.lh.utils.CommentUtils.res;

/**
 * Created by laiHom on 2019/8/26.
 */
@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;
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

        List<Department> list = departmentService.list(map);
        Integer total = departmentService.getTotal(map);
        Gson gson = new Gson();
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

        mav.addObject("btn_text", "添加");
        mav.addObject("save_url", "/department/add");
        mav.setViewName("/admin/departmentAddOrUpdate");
        return mav;
    }

    @RequestMapping("/add")
    public String add(Department department, HttpServletResponse response, HttpServletRequest request) throws Exception {

        int resultTotal = departmentService.addDepartment(department);
        Gson gson = new Gson();
        ResponseUtil.write(response, gson.toJson(res(resultTotal)));
        return null;
    }

    @RequestMapping("/toEdit")
    public ModelAndView toEdit(@RequestParam(value="departmentId",required=false)String departmentId) throws Exception {
        ModelAndView mav = new ModelAndView();

        Department department = departmentService.findById(Integer.parseInt(departmentId));

        mav.addObject("department", department);
        mav.addObject("btn_text", "修改");
        mav.addObject("save_url", "/department/update?departmentId="+departmentId);


        mav.setViewName("/admin/departmentAddOrUpdate");
        return mav;
    }

    @RequestMapping("/update")
    public String update(Department department, HttpServletResponse response, HttpServletRequest request) throws Exception {

        int resultTotal = departmentService.updateDepartment(department);
        Gson gson = new Gson();
        ResponseUtil.write(response, gson.toJson(res(resultTotal)));
        return null;
    }

    //删除
    @RequestMapping("/delete")
    public String delete(@RequestParam(value = "ids", required = false) String ids, HttpServletResponse response)
            throws Exception {
        String[] idsStr = ids.split(",");
        Gson gson = new Gson();
        Result result = new Result();
        departmentService.delete(idsStr);
        result.setSuccess(true);
        ResponseUtil.write(response, gson.toJson(result));
        return null;
    }

    //更新状态setState
    @RequestMapping("/setState")
    public String setState(@RequestParam(value = "departmentId", required = false) String departmentId, HttpServletResponse response)
            throws Exception {
        Gson gson = new Gson();
        Result result = new Result();
        Department department = departmentService.findById(Integer.parseInt(departmentId));
        if(department.getDepartmentState() == 0){
            department.setDepartmentState(1);
        }else {
            department.setDepartmentState(0);
        }
        departmentService.updateDepartment(department);
        result.setSuccess(true);
        ResponseUtil.write(response, gson.toJson(result));
        return null;
    }
}
