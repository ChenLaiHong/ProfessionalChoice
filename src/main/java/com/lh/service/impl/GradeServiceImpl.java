package com.lh.service.impl;

import com.lh.dao.GradeMapper;
import com.lh.pojo.Grade;
import com.lh.pojo.GradeExample;
import com.lh.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static com.lh.utils.CommentUtils.StringIds;

/**
 * Created by laiHom on 2019/8/26.
 */
@Service
public class GradeServiceImpl implements GradeService {
    @Autowired
    private GradeMapper gradeMapper;
    @Override
    public List<Grade> list(Map<String, Object> map) {
        return gradeMapper.list(map);
    }

    @Override
    public Integer getTotal(Map<String, Object> map) {
        return gradeMapper.getTotal(map);
    }

    @Override
    public int addGrade(Grade grade) {
        return gradeMapper.insertSelective(grade);
    }

    @Override
    public Grade findById(int i) {
        return gradeMapper.selectByPrimaryKey(i);
    }

    @Override
    public void delete(String[] idsStr) {

        GradeExample gradeExample = new GradeExample();
        GradeExample.Criteria criteria = gradeExample.createCriteria();
        criteria.andGradeIdIn(StringIds(idsStr));
        gradeMapper.deleteByExample(gradeExample);
    }

    @Override
    public int updateGrade(Grade grade) {
        return gradeMapper.updateByPrimaryKeySelective(grade);
    }

    @Override
    public List<Grade> getAll() {
        return gradeMapper.getAll();
    }
}
