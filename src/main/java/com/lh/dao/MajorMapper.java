package com.lh.dao;

import com.lh.pojo.Major;
import com.lh.pojo.MajorExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface MajorMapper {
    long countByExample(MajorExample example);

    int deleteByExample(MajorExample example);

    int deleteByPrimaryKey(Integer majorId);

    int insert(Major record);

    int insertSelective(Major record);

    List<Major> selectByExampleWithBLOBs(MajorExample example);

    List<Major> selectByExample(MajorExample example);

    Major selectByPrimaryKey(Integer majorId);

    int updateByExampleSelective(@Param("record") Major record, @Param("example") MajorExample example);

    int updateByExampleWithBLOBs(@Param("record") Major record, @Param("example") MajorExample example);

    int updateByExample(@Param("record") Major record, @Param("example") MajorExample example);

    int updateByPrimaryKeySelective(Major record);

    int updateByPrimaryKeyWithBLOBs(Major record);

    int updateByPrimaryKey(Major record);


    List<Major> list(Map<String, Object> map);

    Long getTotal(Map<String, Object> map);


    List<Major> listF(Map<String, Object> map);

    Integer getTotalF(Map<String, Object> map);

    int inputAll(Map<String, Object> map);
}