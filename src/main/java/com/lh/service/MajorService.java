package com.lh.service;

import com.lh.pojo.Major;

import java.util.List;

/**
 * Created by laiHom on 2019/8/20.
 */
public interface MajorService {

    Major getMajorById(Integer id);

    int inputAll(List<Major> majorList);
}
