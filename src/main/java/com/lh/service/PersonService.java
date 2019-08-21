package com.lh.service;


import com.lh.pojo.Person;

/**
 * Created by laiHom on 2019/8/20.
 */
public interface PersonService {
    Person login(String name, String password);

    Person getUserName(String username);
}
