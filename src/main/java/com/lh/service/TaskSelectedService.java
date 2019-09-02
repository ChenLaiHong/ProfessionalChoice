package com.lh.service;

import com.lh.pojo.Result;
import com.lh.pojo.TaskSelected;

public interface TaskSelectedService {

    /**
     * 添加学生选报方向数据
     * @param taskSelected
     * @return
     */
    Result insertTaskSelected(TaskSelected taskSelected);

    /**
     * 修改学生选报方向数据
     * @param taskSelected
     * @return
     */
    Result updateTaskSelected(TaskSelected taskSelected);

    /**
     * 查询学生选报信息
     * @return
     */
    TaskSelected getTaskSelectedByUser();
}
