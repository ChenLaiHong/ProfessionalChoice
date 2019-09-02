package com.lh.controller;


import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.lh.dao.DirectionMapper;
import com.lh.interceptor.RequestHolder;
import com.lh.pojo.*;
import com.lh.service.DirectionService;
import com.lh.service.TaskSelectedService;
import com.lh.utils.MyPageInfo;
import com.lh.utils.RedisKey;
import com.lh.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("task")
public class TaskSelectedController {

    @Autowired
    private TaskSelectedService taskSelectedService;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private RequestHolder requestHolder;

    @Autowired
    private DirectionMapper directionMapper;

    /**
     * 前往学生选报方向页面
     * @return
     */
    @RequestMapping("/page")
    public String page() {
        return "/admin/selected/taskSelectedManage";
    }


    /**
     * 前往学生的选报方向信息
     * @return
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Map<String, Object> listTaskSelected() {
        // 查询出用户选报数据
        TaskSelected taskSelected = taskSelectedService.getTaskSelectedByUser();
        List<TaskSelected> taskSelectedList = new ArrayList<>();
        if (taskSelected != null) {
            taskSelectedList.add(taskSelected);
        }
        // 返回给前台的数据
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("data", taskSelectedList);
        map.put("code", 0);
        map.put("msg", "");
        return map;
    }

    /***
     * 选择方向页面
     * @return
     */
    @RequestMapping("/editPage")
    public ModelAndView toEdit(@RequestParam(value = "id", required = false) Integer id) {
        // 从线程缓存中获取用户数据
        Person user = requestHolder.getPerson();
        ModelAndView modelAndView = new ModelAndView();
        // 查询出用户选了没
        String queryResult = (String)redisUtil.hget(RedisKey.USER_CHOICE, user.getLoginId());

        if (queryResult == null) {
            // 还没选择
            modelAndView.addObject("save_url", "/task/save?taskId=" + id);
        } else {
            // 已选择，从缓存中查出选择信息
            String selectJson = (String)redisUtil.hget(RedisKey.USER_CHOICE, user.getLoginId());
            TaskSelected taskSelected = JSON.parseObject(selectJson, TaskSelected.class);
            // 已选择
            modelAndView.addObject("save_url", "/task/update?id=" + taskSelected.getId());

            modelAndView.addObject("task", taskSelected);
        }

        // 查询出方向
        List<Direction> directionList = directionMapper.listDirectionByChoiceTaskId(id);
        modelAndView.addObject("directionList", directionList);
        modelAndView.addObject("btn_text", "选择方向");
        modelAndView.setViewName("/admin/selected/taskSelectedAddOrUpdate");
        return modelAndView;
    }

    /**
     * 保存选报信息
     * @param taskSelected
     * @return
     */
    @RequestMapping("save")
    @ResponseBody
    public Result save(TaskSelected taskSelected) {
        return taskSelectedService.insertTaskSelected(taskSelected);
    }

    /**
     * 修改选报信息
     * @param taskSelected
     * @return
     */
    @RequestMapping("update")
    @ResponseBody
    public Result update(TaskSelected taskSelected) {
        return taskSelectedService.updateTaskSelected(taskSelected);
    }

}
