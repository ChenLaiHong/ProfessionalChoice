package com.lh.dao;

import com.lh.pojo.Direction;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 专业方向Dao接口
 */
@Mapper
public interface DirectionMapper {

    /**
     * 添加专业方向
     * @param direction
     * @return
     */
    @Insert("insert direction (name, details," +
            "operation_username, major_id, grade_id, create_time, update_time, delete_flag) values" +
            "(#{name}, #{details}, #{operationUsername}, #{majorId}, " +
            "#{gradeId}, #{createTime}, #{updateTime}, #{deleteFlag})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    int insertDirection(Direction direction);

    /**
     * 更新专业方向
     * @param direction
     * @return
     */
    @Update("update direction set name = #{name}, details =  #{details}," +
            "update_time = #{updateTime}, grade_id = #{gradeId} where id = #{id}")
    int updateDirection(Direction direction);

    /**
     * 删除专业方向
     * @param direction
     * @return
     */
    @Delete("update direction set delete_flag = 1 where id = #{id}")
    int deleteDirection(Direction direction);

    /**
     * 查询专业方向，可根据方向名模糊搜索
     * @param direction
     * @return
     */
    List<Direction> listDirection(Direction direction);

    /**
     * 查看方向介绍
     * @param direction
     * @return
     */
    @Select("select details from direction where id = #{id}")
    String getDirectionDetailById(Direction direction);

    @Select("select * from direction where id = #{id} and delete_flag = 0")
    Direction getDirectionById(int id);


}
