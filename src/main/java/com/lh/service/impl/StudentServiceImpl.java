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
import java.util.Map;

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



    @Override
    public List<Person> getStudentTel() {

        Person person = new Person();
        person.setLoginId("xxx");
        person.setName("张三");
        person.setGender(0);
        person.setGrades("4班");
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

    @Override
    public List<Person> list(Map<String, Object> map) {
        return personMapper.list(map);
    }

    @Override
    public Integer getTotal(Map<String, Object> map) {
        return personMapper.getTotal(map);
    }

    @Override
    public int add(Person person) {
        person.setRoleId(1);
        return personMapper.insertSelective(person);
    }

    @Override
    public Person findById(String loginId) {
        return personMapper.selectByPrimaryKey(loginId);
    }

    @Override
    public int update(Person person) {
        return personMapper.updateByPrimaryKeySelective(person);
    }

    @Override
    public void delete(String[] idsStr) {
        List ints = new ArrayList();
        for(int i =0;i<idsStr.length;i++){
            ints.add(idsStr[i]);
        }
        PersonExample personExample = new PersonExample();
        PersonExample.Criteria criteria = personExample.createCriteria();
        criteria.andLoginIdIn(ints);
        personMapper.deleteByExample(personExample);
    }

    @Override
    public int inputAll(Map<String, Object> map) {
        return personMapper.inputAll(map);
    }
}
