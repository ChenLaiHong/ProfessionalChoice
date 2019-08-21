package com.lh.service.impl;

import com.lh.dao.MajorMapper;
import com.lh.pojo.Major;
import com.lh.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public int inputAll(List<Major> majorList) {
        return majorMapper.insertCodeBatch(majorList);
    }
}
