package com.lh.service;

import com.lh.pojo.Major;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by laiHom on 2019/8/20.
 */
public interface MajorService {

    Major getMajorById(Integer id);

    int inputAll(List<Major> majorList, HttpServletRequest request);

    List<Major> findAll();

    List<Major> list(Map<String, Object> map);

    Long getTotal(Map<String, Object> map);

    int addMajor(Major major);

    int updateMajor(Major major);

    int delete(String[] idsStr);
}
