package com.lh.dao;

import com.lh.pojo.TaskSelected;
import org.apache.ibatis.annotations.*;

@Mapper
public interface TaskSelectedMapper {

    @Insert("insert task_selected (task_id, user_id, create_time, update_time, direction_id)" +
            "values (#{taskId}, #{userId}, #{createTime}, #{updateTime}, #{directionId})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insertTaskSelected(TaskSelected taskSelected);

    @Update("update task_selected set update_time = #{updateTime}, direction_id = #{directionId}" +
            " where id = #{id}")
    int updateTaskSelected(TaskSelected taskSelected);

    /**
     * 查询出学生选课的详细信息
     * @param id
     * @return
     */
    @Select("select ts.*, d.name, ct.start_time, ct.end_time from task_selected ts " +
            "inner join direction d " +
            "on ts.direction_id = d.id " +
            "inner join choice_task ct " +
            "on ts.task_id = ct.id " +
            "where ts.id = #{id}")
    TaskSelected getTaskSelectedById(int id);

    @Select("select * from task_selected where id = #{id}")
    TaskSelected getBeforeTaskSelectedById(int id);


}
