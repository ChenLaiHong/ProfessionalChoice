package com.lh.service.impl;

import com.lh.dao.DepartmentMapper;
import com.lh.pojo.Department;
import com.lh.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by laiHom on 2019/8/25.
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;
    @Override
    public List<Department> getAll() {
        return departmentMapper.selectByExample(null);
    }
}
