package com.lh.service;

import com.lh.pojo.Department;

import java.util.List;
import java.util.Map;

/**
 * Created by laiHom on 2019/8/25.
 */
public interface DepartmentService {
    List<Department> getAll();

    List<Department> list(Map<String, Object> map);

    Integer getTotal(Map<String, Object> map);

    int addDepartment(Department department);

    Department findById(int i);

    int updateDepartment(Department department);

    void delete(String[] idsStr);
}
