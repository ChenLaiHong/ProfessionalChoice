package com.lh.service.impl;

import com.lh.dao.RoleResourceMapper;
import com.lh.pojo.RoleResource;
import com.lh.pojo.RoleResourceExample;
import com.lh.service.RoleResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Created by laiHom on 2019/8/29.
 */
@Service
public class RoleResourceServiceImpl implements RoleResourceService{
    @Autowired
    private RoleResourceMapper roleResourceMapper;
    @Override
    public void addRoleResource(RoleResource roleResource) {

        RoleResourceExample roleResourceExample = new RoleResourceExample();
        RoleResourceExample.Criteria criteria = roleResourceExample.createCriteria();
        criteria.andRoleIdEqualTo(roleResource.getRoleId());

        roleResourceMapper.deleteByExample(roleResourceExample);
        //添加
        if(!StringUtils.isEmpty(roleResource.getResoureId())){
            String[] resourcesArr = roleResource.getResoureId().split(",");
            for(String resourcesId:resourcesArr ){
                RoleResource r = new RoleResource();
                r.setRoleId(roleResource.getRoleId());
                r.setResoureId(resourcesId);
                roleResourceMapper.insert(r);
            }
        }
    }
}
