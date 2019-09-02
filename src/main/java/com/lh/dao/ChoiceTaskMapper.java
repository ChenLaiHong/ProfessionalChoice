package com.lh.dao;


import com.lh.pojo.ChoiceTask;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ChoiceTaskMapper {

    @Insert("insert choice_task (grade_id, major_id, start_time, end_time, create_time, update_time," +
            "create_username,delete_flag) values (#{gradeId}, #{majorId}, #{startTime}, #{endTime}, #{createTime}," +
            "#{updateTime}, #{createUsername},0)")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    int insertChoiceTask(ChoiceTask choiceTask);

    @Update("update choice_task set start_time = #{startTime}, end_time = #{endTime}, update_time = #{updateTime}")
    int updateChoiceTask(ChoiceTask choiceTask);

    @Update("update choice_task set delete_flag = 1 where id = #{id}")
    int deleteChoiceTask(ChoiceTask choiceTask);

    List<ChoiceTask> listChoiceTask();

    @Select("select ct.*,g.grade_name,m.major_name from choice_task ct\n" +
            "        inner join grade g\n" +
            "        on ct.grade_id = g.grade_id\n" +
            "        inner join major m\n" +
            "        on ct.major_id = m.major_id\n" +
            "        where ct.delete_flag = 0 and id = #{id}")
    ChoiceTask getChoiceTaskById(int id);

    @Select("select ct.* from choice_task ct \n" +
            "inner join person p\n" +
            "on ct.major_id = p.major_id and ct.grade_id = p.grade_id " +
            "where major_id = #{majorId} and grade_id = #{gradeId} ")
    ChoiceTask getChoiceTaskByMajorIdAndGradeId(ChoiceTask choiceTask);
}
