package com.lh.service;

import com.lh.pojo.Grade;

import java.util.List;
import java.util.Map;

/**
 * Created by laiHom on 2019/8/26.
 */
public interface GradeService {
    List<Grade> list(Map<String, Object> map);

    Integer getTotal(Map<String, Object> map);

    int addGrade(Grade grade);

    Grade findById(int i);

    void delete(String[] idsStr);

    int updateGrade(Grade grade);

    List<Grade> getAll();
}
