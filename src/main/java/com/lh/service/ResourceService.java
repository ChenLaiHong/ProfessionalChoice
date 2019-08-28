package com.lh.service;

import com.lh.pojo.Resource;

import java.util.List;
import java.util.Map;

/**
 * Created by laiHom on 2019/8/28.
 */
public interface ResourceService {

    List<Resource> queryAll();

    List<Resource> loadPersonResources(Map<String, Object> map);
}
