package com.lh.service;

import com.lh.pojo.Person;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by laiHom on 2019/8/20.
 */
public interface StudentService {


    List<Person> findAll();

    int inputAll(List<Person> lists,Integer majorId);
}
