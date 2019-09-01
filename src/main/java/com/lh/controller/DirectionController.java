package com.lh.controller;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.lh.pojo.*;
import com.lh.service.DirectionService;
import com.lh.service.GradeService;
import com.lh.utils.MyPageInfo;
import com.lh.utils.ResponseUtil;
import com.lh.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.lh.utils.CommentUtils.res;

/**
 * 专业方向模块控制类
 */
@Controller
@RequestMapping(value = "direction")
public class DirectionController {

    @Autowired
    private DirectionService directionService;

    @Autowired
    private GradeService gradeService;

    /**
     * 前往专业方向管理页
     * @return
     */
    @RequestMapping(value = "/page")
    public String directionPage(@RequestParam("majorId") Integer majorId, Model model) {
        model.addAttribute("majorId", majorId);
        return "/admin/direction/directionManage";
    }

    /**
     * 查看方向信息
     * @param majorId 方向所属的专业id
     * @param page 页码
     * @param perPage 每页数量
     * @param queryKey 模糊搜索的方向名
     * @return
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Map<String, Object> listDiretion(@RequestParam("majorId") Integer majorId,
                                            @RequestParam(value = "page", required = false) Integer page,
                                            @RequestParam(value = "limit", required = false) Integer perPage,
                                            @RequestParam(value = "q", required = false) String queryKey) {
        // 设置分页信息
        MyPageInfo myPageInfo = new MyPageInfo();
        myPageInfo.setPage(page - 1);
        myPageInfo.setPerPage(perPage);
        // 查询数据
        Direction direction= new Direction();
        direction.setName(queryKey);
        PageInfo<Direction> pageInfo = directionService.listDirection(direction, myPageInfo);

        // 返回给前台的数据
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("data", pageInfo.getList());
        map.put("count", pageInfo.getTotal());
        map.put("code", 0);
        map.put("msg", "");
        return map;
    }

    /**
     * 查看方向介绍
     * @param directionId 方向Id
     * @return
     * @throws Exception
     */
    @RequestMapping("/showDetail")
    public ModelAndView showDetail(@RequestParam(value="directionId", required=false) Integer directionId) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        Direction direction = new Direction();
        direction.setId(directionId);
        String details = directionService.getDirectionDetailById(direction);
        modelAndView.addObject("directionDetails", details);
        modelAndView.setViewName("/admin/direction/directionDetail");
        return modelAndView;
    }

    /**
     * 前往添加方向页面
     * @return
     * @throws Exception
     */
    @RequestMapping("/savePage")
    public ModelAndView insertPage(@RequestParam("majorId") Integer majorId) throws Exception {
        // 获取所有的年级选项
        List<Grade> gradeList = gradeService.getAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("gradeList", gradeList);
        modelAndView.addObject("btn_text", "添加");
        modelAndView.addObject("save_url", "/direction/save");
        // 专业id
        modelAndView.addObject("majorId", majorId);
        modelAndView.setViewName("/admin/direction/directionAddOrUpdate");
        return modelAndView;
    }

    /**
     * 添加方向
     * @param direction
     * @param request
     * @return
     */
    @RequestMapping("save")
    @ResponseBody
    public Result saveDirecction(Direction direction, HttpServletRequest request) {
        // 创建人名
        direction.setOperationUsername((String) request.getSession().getAttribute("userName"));
        return res(directionService.insertDirection(direction));
    }

    @RequestMapping("/editPage")
    public ModelAndView toEdit(@RequestParam(value="majorId") String majorId,
                               @RequestParam(value = "id") Integer id) throws Exception {
        // 获取所有的年级选项
        List<Grade> gradeList = gradeService.getAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("gradeList", gradeList);
        // 专业id
        modelAndView.addObject("majorId", majorId);
        // 查询出当前对象
        Direction direction = directionService.getDirectionById(id);
        modelAndView.addObject("direction", direction);
        modelAndView.addObject("btn_text", "修改");
        modelAndView.addObject("save_url", "/direction/update?id=" + id);
        modelAndView.setViewName("/admin/direction/directionAddOrUpdate");
        return modelAndView;
    }

    @RequestMapping("update")
    @ResponseBody
    public Result updateDirecction(Direction direction, HttpServletRequest request) {
        return res(directionService.updateDirection(direction));
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Result delete(@RequestParam(value = "ids", required = false) String ids) {
        String[] idsStr = ids.split(",");
        Result result = new Result();
        directionService.deleteDirection(idsStr);
        result.setSuccess(true);
        return result;
    }
}
