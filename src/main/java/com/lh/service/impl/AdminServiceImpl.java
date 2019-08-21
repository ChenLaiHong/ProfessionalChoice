package com.lh.service.impl;

import com.lh.dao.AdminMapper;
import com.lh.pojo.Admin;
import com.lh.pojo.AdminExample;
import com.lh.service.AdminService;
import com.lh.utils.MdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by laiHom on 2019/8/20.
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Override
    public Admin login(String name, String password) {
        AdminExample adminExample = new AdminExample();
        adminExample.createCriteria().andAdminNameEqualTo(name).andAdminPasswordEqualTo(MdUtil.md5(password));
        List<Admin> admins = adminMapper.selectByExample(adminExample);
        if(admins.size()>0){
            return admins.get(0);
        }
        return null;
    }
}
