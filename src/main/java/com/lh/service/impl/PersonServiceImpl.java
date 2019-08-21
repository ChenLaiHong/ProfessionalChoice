package com.lh.service.impl;

import com.lh.dao.PersonMapper;

import com.lh.pojo.Person;
import com.lh.pojo.PersonExample;
import com.lh.service.PersonService;
import com.lh.utils.MdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by laiHom on 2019/8/20.
 */
@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonMapper personMapper;

    @Override
    public Person login(String name, String password) {
        PersonExample personExample = new PersonExample();
        personExample.createCriteria().andLoginIdEqualTo(name).andPasswordEqualTo(MdUtil.md5(password));
        List<Person> personList = personMapper.selectByExample(personExample);
        if(personList.size()>0){
            return personList.get(0);
        }
        return null;
    }

    @Override
    public Person getUserName(String username) {
        PersonExample personExample = new PersonExample();
        personExample.createCriteria().andLoginIdEqualTo(username);
        List<Person> personList = personMapper.selectByExample(personExample);
        if(personList.size()>0){
            return personList.get(0);
        }
        return null;
    }
}
