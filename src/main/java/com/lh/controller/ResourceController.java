package com.lh.controller;

import com.lh.pojo.Resource;
import com.lh.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by laiHom on 2019/8/29.
 */
@RestController
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @RequestMapping(value = "/resourcesWithSelected", method = { RequestMethod.POST })
    public List<Resource> resourcesWithSelected(Integer rid){

        return resourceService.queryResourcesListWithSelected(rid);
    }
}
