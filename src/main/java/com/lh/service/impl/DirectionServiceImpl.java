package com.lh.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lh.dao.DirectionMapper;
import com.lh.pojo.Direction;
import com.lh.service.DirectionService;
import com.lh.utils.MyPageInfo;
import com.lh.utils.RedisKey;
import com.lh.utils.RedisUtil;
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

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public int insertDirection(Direction direction) {
        direction.setCreateTime(new Date());
        direction.setUpdateTime(new Date());
        direction.setSelectedNumber(0);
        int num = directionMapper.insertDirection(direction);
        // 方向添加成功，将方向的限制人数添加到Redis，key为方向id，value为方向限选人数
        redisUtil.incr(RedisKey.DIRECTION_LIMIT + String.valueOf(direction.getId()), direction.getLimitNumber());
        // 选课初始人数，方向刚添加，人数仍为0
        redisUtil.incr(RedisKey.DIRECTION_SELECTED + String.valueOf(direction.getId()), 0);
        return num;
    }

    @Override
    public int updateDirection(Direction direction) {
        direction.setUpdateTime(new Date());
        int num = directionMapper.updateDirection(direction);
        // 查询出更新后的数据
        direction = directionMapper.getDirectionById(direction.getId());
        // 方向修改成功，修改redis缓存，注意不能直接重置value，要修改为限选人数 - 已选人数
        // 因为后台是通过判断redis缓存判断value不为0才进行选课
        redisUtil.incr(RedisKey.DIRECTION_LIMIT + String.valueOf(direction.getId()), direction.getLimitNumber() - direction.getSelectedNumber());
        return num;
    }

    @Override
    public void deleteDirection(String[] ids) {
        for (String id: ids) {
            Direction direction = new Direction();
            direction.setId(Integer.valueOf(id));
            directionMapper.deleteDirection(direction);
            // 删除redis缓存
            redisUtil.del(RedisKey.DIRECTION_LIMIT + String.valueOf(direction.getId()));
            redisUtil.del(RedisKey.DIRECTION_SELECTED + String.valueOf(direction.getId()));
        }
    }

    @Override
    public PageInfo<Direction> listDirection(Direction direction, MyPageInfo myPageInfo) {
        // 设置分页参数
        PageHelper.startPage(myPageInfo.getPage(), myPageInfo.getPerPage());
        // 查询方向信息并封装成分页对象
        PageInfo<Direction> pageInfo = new PageInfo<>(directionMapper.listDirection(direction));
        // 管理员查询的时候将redis里面的已选择人数保存到数据库
        for (Direction d: pageInfo.getList()) {
            Integer num = (Integer) redisUtil.get(RedisKey.DIRECTION_SELECTED + String.valueOf(d.getId()));
            d.setSelectedNumber(num);
            directionMapper.updateDirectionSelectNumber(d);
        }
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
