package com.lh.service.impl;

import com.lh.dao.PersonMapper;
import com.lh.pojo.Person;
import com.lh.pojo.Teacher;
import com.lh.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by laiHom on 2019/8/28.
 */
@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private PersonMapper personMapper;
    @Override
    public List<Person> listT(Map<String, Object> map) {
        return personMapper.listT(map);
    }

    @Override
    public Integer getTotalT(Map<String, Object> map) {
        return personMapper.getTotalT(map);
    }

    @Override
    public int add(Person person) {
        return personMapper.insertSelective(person);
    }

    @Override
    public int update(Person person) {
        return personMapper.updateByPrimaryKeySelective(person);
    }


    @Override
    public int inputAll(Map<String, Object> map) {
        return personMapper.inputAllT(map);
    }

    @Override
    public List<Teacher> getAll() {
        return personMapper.select();
    }

    @Override
    public List<Teacher> getTeacherTel() {
        Teacher teacher = new Teacher();
        teacher.setLoginId("xxx");
        teacher.setName("张三");
        teacher.setGender(0);
        List<Teacher> list = new ArrayList<>();
        list.add(teacher);
        return list;
    }
}
