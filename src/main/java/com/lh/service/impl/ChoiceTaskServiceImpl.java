package com.lh.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lh.dao.ChoiceTaskMapper;
import com.lh.pojo.ChoiceTask;
import com.lh.pojo.Direction;
import com.lh.service.ChoiceTaskService;
import com.lh.utils.MyPageInfo;
import com.lh.utils.RedisKey;
import com.lh.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ChoiceTaskServiceImpl implements ChoiceTaskService{

    @Autowired
    private ChoiceTaskMapper choiceTaskMapper;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public int insertChoiceTask(ChoiceTask choiceTask) {
        choiceTask.setCreateTime(new Date());
        choiceTask.setUpdateTime(new Date());
        int num = choiceTaskMapper.insertChoiceTask(choiceTask);
        // 选课任务发布成功，将任务保存到集合中，key为任务对应的年级和专业id，方便用户查看自己有没有选课任务
        redisUtil.hset(RedisKey.CHOICE_TASK, choiceTask.getMajorId() + "_" + choiceTask.getGradeId(),
                JSON.toJSONString(choiceTask, true));
        return num;
    }

    @Override
    public int updateChoiceTask(ChoiceTask choiceTask) {
        choiceTask.setUpdateTime(new Date());
        int num = choiceTaskMapper.updateChoiceTask(choiceTask);
        // 修改成功，更新Redis里面的数据
        redisUtil.hset(RedisKey.CHOICE_TASK, choiceTask.getMajorId() + "_" + choiceTask.getGradeId(),
                JSON.toJSONString(choiceTask, true));
        return num;
    }

    @Override
    public void deleteChoiceTask(String[] ids) {
        for (String id: ids) {
            // 取出要删除的任务信息，用于删除Redis里面的缓存信息
            ChoiceTask result = choiceTaskMapper.getChoiceTaskById(Integer.valueOf(id));
            ChoiceTask choiceTask = new ChoiceTask();
            choiceTask.setId(Integer.valueOf(id));
            choiceTaskMapper.deleteChoiceTask(choiceTask);
            // 删除Redis里面的缓存信息
            redisUtil.hdel(RedisKey.CHOICE_TASK, choiceTask.getMajorId() + "_" + choiceTask.getGradeId());
        }
    }

    @Override
    public PageInfo<ChoiceTask> listChoiceTask(MyPageInfo myPageInfo) {
        // 设置分页参数
        PageHelper.startPage(myPageInfo.getPage(), myPageInfo.getPerPage());
        // 查询方向信息并封装成分页对象
        PageInfo<ChoiceTask> pageInfo = new PageInfo<>(choiceTaskMapper.listChoiceTask());
        return pageInfo;
    }

    @Override
    public ChoiceTask getChoiceTaskById(int id) {
        ChoiceTask choiceTask = choiceTaskMapper.getChoiceTaskById(id);
        choiceTask.setStartTimeLong(choiceTask.getStartTime().getTime());
        choiceTask.setEndTimeLong(choiceTask.getEndTime().getTime());
        return choiceTask;
    }
}
