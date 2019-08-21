package com.lh.service;

import com.lh.pojo.Admin;

/**
 * Created by laiHom on 2019/8/20.
 */
public interface AdminService {
    Admin login(String name, String password);
}
