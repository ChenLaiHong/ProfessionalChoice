package com.lh.dao;

import com.lh.pojo.Notice;
import com.lh.pojo.NoticeExample;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.ibatis.annotations.Param;

public interface NoticeMapper {
    long countByExample(NoticeExample example);

    int deleteByExample(NoticeExample example);

    int deleteByPrimaryKey(Integer noticeId);

    int insert(Notice record);

    int insertSelective(Notice record);

    List<Notice> selectByExampleWithBLOBs(NoticeExample example);

    List<Notice> selectByExample(NoticeExample example);

    Notice selectByPrimaryKey(Integer noticeId);

    int updateByExampleSelective(@Param("record") Notice record, @Param("example") NoticeExample example);

    int updateByExampleWithBLOBs(@Param("record") Notice record, @Param("example") NoticeExample example);

    int updateByExample(@Param("record") Notice record, @Param("example") NoticeExample example);

    int updateByPrimaryKeySelective(Notice record);

    int updateByPrimaryKeyWithBLOBs(Notice record);

    int updateByPrimaryKey(Notice record);

    List<Objects> list(Map<String, Object> map);

    Long getTotal(Map<String, Object> map);

    List<Objects> searchList(Map<String, Object> listFirst);

    Long getSearchTotal(Map<String, Object> listFirst);

    List<Notice> listF(Map<String, Object> map);

    Integer getTotalF(Map<String, Object> map);

    List<Notice> getAll();
}