package com.lh.service;

import com.lh.pojo.Image;

/**
 * Created by laiHom on 2019/8/31.
 */
public interface ImageService {
    Image findById(String id);

    void inster(Image image);

    void update(Image image);
}
