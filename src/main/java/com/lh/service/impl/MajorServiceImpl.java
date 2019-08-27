package com.lh.service.impl;

import com.lh.dao.MajorMapper;
import com.lh.pojo.Major;
import com.lh.pojo.MajorExample;
import com.lh.pojo.Person;
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

    @Override
    public List<Major> getAll() {
        return majorMapper.selectByExample(null);
    }

    @Override
    public List<Major> listF(Map<String, Object> map) {
        return majorMapper.listF(map);
    }

    @Override
    public Integer getTotalF(Map<String, Object> map) {
        return majorMapper.getTotalF(map);
    }

    @Override
    public Major findById(int i) {
        return majorMapper.selectByPrimaryKey(i);
    }

    @Override
    public List<Major> getMajorTel() {
        Major major = new Major();
        major.setMajorName("xxx");
        major.setMajorCode("12052xx");
        major.setMajorYear(4);
        major.setMajorMoney(20400);
        major.setMajorDetails("xxxxx");
        List<Major> list = new ArrayList<>();
        list.add(major);
        return list;
    }

    @Override
    public String findDetailsById(String majorId) {
        return majorMapper.selectByPrimaryKey(Integer.valueOf(majorId)).getMajorDetails();
    }

    @Override
    public int inputAll(Map<String, Object> map) {
        return majorMapper.inputAll(map);
    }
}
