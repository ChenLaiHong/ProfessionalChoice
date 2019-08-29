package com.lh.controller;

import com.google.gson.Gson;
import com.lh.pojo.Role;
import com.lh.pojo.PageBean;
import com.lh.pojo.Result;
import com.lh.pojo.RoleResource;
import com.lh.service.RoleResourceService;
import com.lh.service.RoleService;
import com.lh.utils.ResponseUtil;
import com.lh.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
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
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;
    @Autowired
    private RoleResourceService roleResourceService;
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

        List<Role> list = roleService.list(map);
        Integer total = roleService.getTotal(map);
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
        mav.addObject("save_url", "/role/add");
        mav.setViewName("/admin/roleAddOrUpdate");
        return mav;
    }

    @RequestMapping("/add")
    public String add(Role role, HttpServletResponse response, HttpServletRequest request) throws Exception {

        int resultTotal = roleService.addRole(role);
        Gson gson = new Gson();
        ResponseUtil.write(response, gson.toJson(res(resultTotal)));
        return null;
    }

    @RequestMapping("/toEdit")
    public ModelAndView toEdit(@RequestParam(value="roleId",required=false)String roleId) throws Exception {
        ModelAndView mav = new ModelAndView();

        Role role = roleService.getById(Integer.parseInt(roleId));

        mav.addObject("role", role);
        mav.addObject("btn_text", "修改");
        mav.addObject("save_url", "/role/update?roleId="+roleId);


        mav.setViewName("/admin/roleAddOrUpdate");
        return mav;
    }

    @RequestMapping("/update")
    public String update(Role role, HttpServletResponse response, HttpServletRequest request) throws Exception {

        int resultTotal = roleService.updateRole(role);
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
        roleService.delete(idsStr);
        result.setSuccess(true);
        ResponseUtil.write(response, gson.toJson(result));
        return null;
    }

    //分配角色
    @RequestMapping("/saveRoleResources")
    public String saveRoleResources(RoleResource roleResource){
        if(StringUtils.isEmpty(roleResource.getRoleId()))
            return "error";
        try {
            roleResourceService.addRoleResource(roleResource);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }
}
