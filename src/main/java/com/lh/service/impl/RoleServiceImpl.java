package com.lh.service.impl;

import com.lh.dao.RoleMapper;
import com.lh.pojo.Role;
import com.lh.pojo.RoleExample;
import com.lh.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static com.lh.utils.CommentUtils.StringIds;

/**
 * Created by laiHom on 2019/8/28.
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public Role getById(Integer roleId) {
        return roleMapper.selectByPrimaryKey(roleId);
    }

    @Override
    public List<Role> list(Map<String, Object> map) {
        return roleMapper.list(map);
    }

    @Override
    public Integer getTotal(Map<String, Object> map) {
        return roleMapper.getTotal(map);
    }

    @Override
    public int addRole(Role role) {
        return roleMapper.insertSelective(role);
    }

    @Override
    public int updateRole(Role role) {
        return roleMapper.updateByPrimaryKeySelective(role);
    }

    @Override
    public void delete(String[] idsStr) {

        RoleExample roleExample = new RoleExample();
        RoleExample.Criteria criteria = roleExample.createCriteria();
        criteria.andRoleIdIn(StringIds(idsStr));
        roleMapper.deleteByExample(roleExample);
    }
}
