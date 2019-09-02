package com.lh.controller;

import com.github.pagehelper.PageInfo;
import com.lh.dao.ChoiceTaskMapper;
import com.lh.pojo.*;
import com.lh.service.ChoiceTaskService;
import com.lh.service.DirectionService;
import com.lh.service.GradeService;
import com.lh.service.MajorService;
import com.lh.utils.MyPageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.lh.utils.CommentUtils.res;


@Controller
@RequestMapping(value = "choiceTask")
public class ChoiceTaskController {

    @Autowired
    private ChoiceTaskService choiceTaskService;

    @Autowired
    private GradeService gradeService;

    @Autowired
    private MajorService majorService;

    @RequestMapping(value = "/page")
    public String choiceTaskPage() {
        return "/admin/task/choiceTaskManage";
    }


    @RequestMapping(value = "/list")
    @ResponseBody
    public Map<String, Object> listChoiceTask(@RequestParam(value = "page", required = false) Integer page,
                                            @RequestParam(value = "limit", required = false) Integer perPage) {
        // 设置分页信息
        MyPageInfo myPageInfo = new MyPageInfo();
        myPageInfo.setPage(page - 1);
        myPageInfo.setPerPage(perPage);
        PageInfo<ChoiceTask> pageInfo = choiceTaskService.listChoiceTask(myPageInfo);
        // 返回给前台的数据
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("data", pageInfo.getList());
        map.put("count", pageInfo.getTotal());
        map.put("code", 0);
        map.put("msg", "");
        return map;
    }

    @RequestMapping("/savePage")
    public ModelAndView insertPage() throws Exception {
        // 获取所有的年级选项
        List<Grade> gradeList = gradeService.getAll();
        ModelAndView modelAndView = new ModelAndView();
        // 获取所有的专业
        List<Major> majorList = majorService.getAll();
        modelAndView.addObject("gradeList", gradeList);
        modelAndView.addObject("majorList", majorList);
        modelAndView.addObject("btn_text", "添加");
        modelAndView.addObject("save_url", "/choiceTask/save");
        modelAndView.setViewName("/admin/task/choiceTaskAddOrUpdate");
        return modelAndView;
    }


    @RequestMapping("save")
    @ResponseBody
    public Result saveChoiceTask(ChoiceTask choiceTask, HttpServletRequest request, String time) {
        // 创建人名
        choiceTask.setCreateUsername((String) request.getSession().getAttribute("userName"));
        return res(choiceTaskService.insertChoiceTask(choiceTask));
    }

    @RequestMapping("/editPage")
    public ModelAndView toEdit(@RequestParam(value = "id") Integer id) {
        // 获取所有的年级选项
        List<Grade> gradeList = gradeService.getAll();
        ModelAndView modelAndView = new ModelAndView();
        // 获取所有的专业
        List<Major> majorList = majorService.getAll();
        modelAndView.addObject("gradeList", gradeList);
        modelAndView.addObject("majorList", majorList);

        // 查询出当前对象
        ChoiceTask choiceTask = choiceTaskService.getChoiceTaskById(id);
        modelAndView.addObject("choiceTask", choiceTask);
        modelAndView.addObject("btn_text", "修改");
        modelAndView.addObject("save_url", "/choiceTask/update?id=" + id);
        modelAndView.setViewName("/admin/task/choiceTaskAddOrUpdate");
        return modelAndView;
    }

    @RequestMapping("update")
    @ResponseBody
    public Result updateChoiceTask(ChoiceTask choiceTask) {
        return res(choiceTaskService.updateChoiceTask(choiceTask));
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Result delete(@RequestParam(value = "ids", required = false) String ids) {
        String[] idsStr = ids.split(",");
        Result result = new Result();
        choiceTaskService.deleteChoiceTask(idsStr);
        result.setSuccess(true);
        return result;
    }
}
