package com.lh.service;


import com.github.pagehelper.PageInfo;
import com.lh.pojo.ChoiceTask;
import com.lh.pojo.Direction;
import com.lh.utils.MyPageInfo;

import java.util.List;

public interface ChoiceTaskService {

    int insertChoiceTask(ChoiceTask choiceTask);

    int updateChoiceTask(ChoiceTask choiceTask);

    void deleteChoiceTask(String[] ids);

    PageInfo<ChoiceTask> listChoiceTask(MyPageInfo myPageInfo);

    ChoiceTask getChoiceTaskById(int id);
}
