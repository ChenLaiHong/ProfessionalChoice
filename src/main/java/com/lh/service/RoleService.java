package com.lh.service;

import com.lh.pojo.Role;

import java.util.List;
import java.util.Map;

/**
 * Created by laiHom on 2019/8/28.
 */
public interface RoleService {
    Role getById(Integer roleId);

    List<Role> list(Map<String, Object> map);

    Integer getTotal(Map<String, Object> map);

    int addRole(Role role);

    int updateRole(Role role);

    void delete(String[] idsStr);
}
