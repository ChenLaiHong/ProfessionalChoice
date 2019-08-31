package com.lh.service.impl;

import com.lh.dao.ImageMapper;
import com.lh.pojo.Image;
import com.lh.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by laiHom on 2019/8/31.
 */
@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    private ImageMapper imageMapper;

    @Override
    public Image findById(String id) {
        return imageMapper.selectByPrimaryKey(id);
    }

    @Override
    public void inster(Image image) {
        imageMapper.insertSelective(image);
    }

    @Override
    public void update(Image image) {
        imageMapper.updateByPrimaryKey(image);
    }
}
