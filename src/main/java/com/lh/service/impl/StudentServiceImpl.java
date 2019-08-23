package com.lh.service.impl;

import com.lh.dao.PersonMapper;
import com.lh.pojo.Person;
import com.lh.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
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
}
