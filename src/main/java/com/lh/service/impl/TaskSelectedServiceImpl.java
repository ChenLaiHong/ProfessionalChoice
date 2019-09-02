package com.lh.service.impl;

import com.alibaba.fastjson.JSON;
import com.lh.dao.TaskSelectedMapper;
import com.lh.interceptor.RequestHolder;
import com.lh.pojo.ChoiceTask;
import com.lh.pojo.Person;
import com.lh.pojo.Result;
import com.lh.pojo.TaskSelected;
import com.lh.service.TaskSelectedService;
import com.lh.utils.RedisKey;
import com.lh.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TaskSelectedServiceImpl implements TaskSelectedService {

    @Autowired
    private TaskSelectedMapper taskSelectedMapper;

    @Autowired
    private RequestHolder requestHolder;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public Result insertTaskSelected(TaskSelected taskSelected) {
        // 返回结果对象
        Result result = new Result();
        // 从线程缓存中获取用户数据
        Person user = requestHolder.getPerson();
        // 查询用户有没有对应的选方向任务
        String taskJson = (String)redisUtil.hget(RedisKey.CHOICE_TASK, user.getMajorId() + "_" + user.getGradeId());
        ChoiceTask choiceTask;

        // 用户没有选方向任务，直接返回0，选方向失败
        if (taskJson == null) {
            result.setSuccess(false);
            result.setMsg("无选报方向任务");
            return result;
        }

        // 将json转为对象
        choiceTask = JSON.parseObject(taskJson, ChoiceTask.class);

        // 判断选方向是否已开始或者结束
        Date now = new Date();
        if ((now.getTime() - choiceTask.getStartTime().getTime()) < 0) {
            result.setSuccess(false);
            result.setMsg("尚未开始选报方向");
            return result;
        } else if ((now.getTime() - choiceTask.getEndTime().getTime()) >= 0) {
            result.setSuccess(false);
            result.setMsg("选报方向任务已结束");
            return result;
        }

        /**
         * 将用户选择的方向id作为Key,然后将该key对应的value值减1，只要减完后的值大于
         * 等于0，将表示该方向还是可以选的
         * redis的decr命令是并发安全的
         */
        Long number = redisUtil.decr(String.valueOf(taskSelected.getDirectionId()), 1);
        // 人数已满，选方向失败
        if (number < 0) {
            result.setSuccess(false);
            result.setMsg("方向人数已满，选择失败");
            return result;
        }

        // 将选方向信息保存进数据库
        taskSelected.setCreateTime(new Date());
        taskSelected.setUpdateTime(new Date());
        taskSelected.setUserId(user.getLoginId());
        int num = taskSelectedMapper.insertTaskSelected(taskSelected);
        // 选方向成功，查询出详细数据保存进redis
        TaskSelected queryResult = taskSelectedMapper.getTaskSelectedById(taskSelected.getId());
        // key为学生信息id，value为选方向数据
        redisUtil.hset(RedisKey.USER_CHOICE, queryResult.getUserId(), JSON.toJSONString(queryResult));
        result.setSuccess(true);
        result.setMsg("选择成功");
        return result;
    }

    @Override
    public Result updateTaskSelected(TaskSelected taskSelected) {
        // 返回结果对象
        Result result = new Result();
        // 从线程缓存中获取用户数据
        Person user = requestHolder.getPerson();
        // 查询用户有没有对应的选方向任务
        String taskJson = (String)redisUtil.hget(RedisKey.CHOICE_TASK, user.getMajorId() + "_" + user.getGradeId());
        ChoiceTask choiceTask;

        // 用户没有选方向任务，直接返回0，选方向失败
        if (taskJson == null) {
            result.setSuccess(false);
            result.setMsg("无选报方向任务");
            return result;
        }

        // 将json转为对象
        choiceTask = JSON.parseObject(taskJson, ChoiceTask.class);

        // 判断选方向是否已开始或者结束
        Date now = new Date();
        if ((now.getTime() - choiceTask.getStartTime().getTime()) < 0) {
            result.setSuccess(false);
            result.setMsg("尚未开始选报方向");
            return result;
        } else if ((now.getTime() - choiceTask.getEndTime().getTime()) >= 0) {
            result.setSuccess(false);
            result.setMsg("选报方向任务已结束");
            return result;
        }

        /**
         * 将用户选择的方向id作为Key,然后将该key对应的value值减1，只要减完后的值大于
         * 等于0，将表示该方向还是可以选的
         * redis的decr命令是并发安全的
         */
        Long number = redisUtil.decr(String.valueOf(taskSelected.getDirectionId()), 1);
        // 人数已满，选方向失败
        if (number < 0) {
            result.setSuccess(false);
            result.setMsg("方向人数已满，选择失败");
            return result;
        }

        // 将选方向信息保存进数据库
        taskSelected.setUpdateTime(new Date());
        int num = taskSelectedMapper.updateTaskSelected(taskSelected);
        // 修改选方向成功，查询出详细数据保存进redis
        TaskSelected queryResult = taskSelectedMapper.getTaskSelectedById(taskSelected.getId());
        // key为学生信息id，value为选方向数据
        redisUtil.hset(RedisKey.USER_CHOICE, queryResult.getUserId(), JSON.toJSONString(queryResult));
        result.setSuccess(true);
        result.setMsg("修改成功");
        return result;
    }

    @Override
    public TaskSelected getTaskSelectedByUser() {
        // 从线程缓存中获取用户数据
        Person user = requestHolder.getPerson();

        // 查询用户有没有对应的选方向任务
        String taskJson = (String)redisUtil.hget(RedisKey.CHOICE_TASK, user.getMajorId() + "_" + user.getGradeId());
        // 用户没有选方向任务，直接返回
        if (taskJson == null) {
            return null;
        }
        ChoiceTask choiceTask = JSON.parseObject(taskJson, ChoiceTask.class);
        // 有选方向任务，查询用户选择了没
        String queryResult = (String)redisUtil.hget(RedisKey.USER_CHOICE, user.getLoginId());
        TaskSelected taskSelected;

        if (queryResult == null) {
            // 未选择
            // 查询出选报方向任务
            taskSelected = new TaskSelected();
            // 开始时间
            taskSelected.setStartTime(choiceTask.getStartTime());
            // 结束事件
            taskSelected.setEndTime(choiceTask.getEndTime());
            // 任务id
            taskSelected.setTaskId(choiceTask.getId());
            taskSelected.setId(choiceTask.getId());
        } else {
            // 已选择，从缓存中查出选择信息
            String selectJson = (String)redisUtil.hget(RedisKey.USER_CHOICE, user.getLoginId());
            taskSelected = JSON.parseObject(selectJson, TaskSelected.class);
            taskSelected.setId(choiceTask.getId());
        }

        // 判断任务状态
        Date now = new Date();
        if ((now.getTime() - choiceTask.getStartTime().getTime()) < 0) {
           taskSelected.setState("未开始");
        } else if ((now.getTime() - choiceTask.getEndTime().getTime()) >= 0) {
            taskSelected.setState("已结束");
        } else {
            taskSelected.setState("正在进行");
        }
        return taskSelected;
    }
}
