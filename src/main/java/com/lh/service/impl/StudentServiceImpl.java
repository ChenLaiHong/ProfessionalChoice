package com.lh.service.impl;

import com.lh.dao.PersonMapper;
import com.lh.pojo.MajorExample;
import com.lh.pojo.Person;
import com.lh.pojo.PersonExample;
import com.lh.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by laiHom on 2019/8/20.
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private PersonMapper personMapper;

    @Override
    public List<Person> findAll() {
        return null;
    }

    //导入学生信息
    @Override
    public int inputAll(List<Person> lists,Integer majorId) {
        for (int i=0; i< lists.size();i++){
            lists.get(i).setRoleId(1);
            lists.get(i).setStaticLive(0);
            lists.get(i).setStudentStatus(1);
            lists.get(i).setMajorId(majorId);
        }
        return personMapper.inputAll(lists);
    }

    @Override
    public List<Person> getsTudentTel() {

        Person person = new Person();
        person.setLoginId("xxx");
        person.setName("xxx");
        person.setPassword("000000");
        person.setGender(0);
        person.setPhone("137xxx");
        person.setQqNumber("1185xxx");
        person.setEmail("xxx@qq.com");
        person.setGrades("4班");
        person.setGrade(2016);
        List<Person> list = new ArrayList<>();
        list.add(person);
        return list;
    }

    @Override
    public List<Person> getAll() {
        PersonExample example = new PersonExample();
        PersonExample.Criteria criteria = example.createCriteria();
        criteria.andRoleIdEqualTo(1);
        return personMapper.selectByExample(example);
    }
}
