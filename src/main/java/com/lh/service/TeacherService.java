package com.lh.service;

import com.lh.pojo.Person;
import com.lh.pojo.Teacher;

import java.util.List;
import java.util.Map;

/**
 * Created by laiHom on 2019/8/28.
 */
public interface TeacherService {
    List<Person> listT(Map<String, Object> map);

    Integer getTotalT(Map<String, Object> map);

    int add(Person person);

    int update(Person person);


    int inputAll(Map<String, Object> map);

    List<Teacher> getAll();

    List<Teacher> getTeacherTel();
}
