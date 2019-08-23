package com.lh.service.impl;

import com.lh.dao.MajorMapper;
import com.lh.pojo.Major;
import com.lh.pojo.MajorExample;
import com.lh.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

import java.util.*;

import static com.lh.utils.CommentUtils.StringIds;

/**
 * Created by laiHom on 2019/8/20.
 */
@Service
public class MajorServiceImpl implements MajorService {

    @Autowired
    private MajorMapper majorMapper;
    @Override
    public Major getMajorById(Integer id) {
        Major major = majorMapper.selectByPrimaryKey(id);
        return major;
    }

    @Override
    public int inputAll(List<Major> majorList,HttpServletRequest request) {

        String name = (String) request.getSession().getAttribute("userName");
        List<Major> newMajorList = majorList;
        for (int i=0; i<majorList.size();i++){
            newMajorList.get(i).setPersonName(name);
        }
        System.out.println(newMajorList);
        return majorMapper.insertCodeBatch(newMajorList);
    }

    @Override
    public List<Major> findAll() {
        return majorMapper.selectByExampleWithBLOBs(null);
    }

    @Override
    public List<Major> list(Map<String, Object> map) {
        return majorMapper.list(map);
    }

    @Override
    public Long getTotal(Map<String, Object> map) {
        return majorMapper.getTotal(map);
    }

    @Override
    public int addMajor(Major major) {
        return majorMapper.insertSelective(major);
    }

    @Override
    public int updateMajor(Major major) {
        return majorMapper.updateByPrimaryKeyWithBLOBs(major);
    }

    @Override
    public int delete(String[] idsStr) {

        MajorExample example = new MajorExample();
        MajorExample.Criteria criteria = example.createCriteria();
        criteria.andMajorIdIn(StringIds(idsStr));
        return majorMapper.deleteByExample(example);
    }
}
