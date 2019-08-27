package com.lh.service.impl;

import com.lh.dao.DepartmentMapper;
import com.lh.pojo.Department;
import com.lh.pojo.DepartmentExample;
import com.lh.pojo.GradeExample;
import com.lh.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static com.lh.utils.CommentUtils.StringIds;

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

    @Override
    public List<Department> list(Map<String, Object> map) {
        return departmentMapper.list(map);
    }

    @Override
    public Integer getTotal(Map<String, Object> map) {
        return departmentMapper.getTotal(map);
    }

    @Override
    public int addDepartment(Department department) {
        return departmentMapper.insertSelective(department);
    }

    @Override
    public Department findById(int i) {
        return departmentMapper.selectByPrimaryKey(i);
    }

    @Override
    public int updateDepartment(Department department) {
        return departmentMapper.updateByPrimaryKeySelective(department);
    }

    @Override
    public void delete(String[] idsStr) {
        DepartmentExample departmentExample = new DepartmentExample();
        DepartmentExample.Criteria criteria = departmentExample.createCriteria();
        criteria.andDepartmentIdIn(StringIds(idsStr));
        departmentMapper.deleteByExample(departmentExample);
    }
}
