package com.lh.service.impl;

import com.lh.dao.ResourceMapper;
import com.lh.pojo.*;
import com.lh.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by laiHom on 2019/8/28.
 */
@Service
public class ResourceServiceImpl implements ResourceService {
    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    public List<Resource> queryAll() {
        return resourceMapper.selectByExample(null);
    }

    @Override
    public List<Resource> loadPersonResources(Map<String, Object> map) {
        return resourceMapper.loadPersonResources(map);
    }

    @Override
    public List<Resource> queryResourcesListWithSelected(Integer rid) {
        return resourceMapper.queryResourcesListWithSelected(rid);
    }
}
