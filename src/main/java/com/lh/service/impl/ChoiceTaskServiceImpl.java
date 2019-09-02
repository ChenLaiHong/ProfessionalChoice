package com.lh.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lh.dao.ChoiceTaskMapper;
import com.lh.pojo.ChoiceTask;
import com.lh.pojo.Direction;
import com.lh.service.ChoiceTaskService;
import com.lh.utils.MyPageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ChoiceTaskServiceImpl implements ChoiceTaskService{

    @Autowired
    private ChoiceTaskMapper choiceTaskMapper;

    @Override
    public int insertChoiceTask(ChoiceTask choiceTask) {
        choiceTask.setCreateTime(new Date());
        choiceTask.setUpdateTime(new Date());
        return choiceTaskMapper.insertChoiceTask(choiceTask);
    }

    @Override
    public int updateChoiceTask(ChoiceTask choiceTask) {
        choiceTask.setUpdateTime(new Date());
        return choiceTaskMapper.updateChoiceTask(choiceTask);
    }

    @Override
    public void deleteChoiceTask(String[] ids) {
        for (String id: ids) {
            ChoiceTask choiceTask = new ChoiceTask();
            choiceTask.setId(Integer.valueOf(id));
            choiceTaskMapper.deleteChoiceTask(choiceTask);
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
