package com.lh.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lh.dao.DirectionMapper;
import com.lh.pojo.Direction;
import com.lh.service.DirectionService;
import com.lh.utils.MyPageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 专业方向Service接口实现类
 */
@Service
public class DirectionServiceImpl implements DirectionService {

    @Autowired
    private DirectionMapper directionMapper;

    @Override
    public int insertDirection(Direction direction) {
        direction.setCreateTime(new Date());
        direction.setUpdateTime(new Date());
        return directionMapper.insertDirection(direction);
    }

    @Override
    public int updateDirection(Direction direction) {
        direction.setUpdateTime(new Date());
        return directionMapper.updateDirection(direction);
    }

    @Override
    public void deleteDirection(String[] ids) {
        for (String id: ids) {
            Direction direction = new Direction();
            direction.setId(Integer.valueOf(id));
            directionMapper.deleteDirection(direction);
        }
    }

    @Override
    public PageInfo<Direction> listDirection(Direction direction, MyPageInfo myPageInfo) {
        // 设置分页参数
        PageHelper.startPage(myPageInfo.getPage(), myPageInfo.getPerPage());
        // 查询方向信息并封装成分页对象
        PageInfo<Direction> pageInfo = new PageInfo<>(directionMapper.listDirection(direction));
        return pageInfo;
    }

    @Override
    public String getDirectionDetailById(Direction direction) {
        return directionMapper.getDirectionDetailById(direction);
    }

    @Override
    public Direction getDirectionById(int id) {
        return directionMapper.getDirectionById(id);
    }


}
