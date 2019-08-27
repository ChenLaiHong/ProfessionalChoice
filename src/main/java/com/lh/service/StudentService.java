package com.lh.service;

import com.lh.pojo.Person;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by laiHom on 2019/8/20.
 */
public interface StudentService {


    List<Person> findAll();


    List<Person> getStudentTel();

    List<Person> getAll();

    List<Person> list(Map<String, Object> map);

    Integer getTotal(Map<String, Object> map);

    int add(Person person);

    Person findById(String loginId);

    int update(Person person);

    void delete(String[] idsStr);

    int inputAll(Map<String, Object> map);
}
