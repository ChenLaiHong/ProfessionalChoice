package com.lh.service;

import com.github.pagehelper.PageInfo;
import com.lh.pojo.Direction;
import com.lh.utils.MyPageInfo;

import java.util.List;

/**
 * 专业方向Service接口
 */
public interface DirectionService {

    /**
     * 添加专业方向
     * @param direction
     * @return
     */
    int insertDirection(Direction direction);

    /**
     * 更新专业方向
     * @param direction
     * @return
     */
    int updateDirection(Direction direction);

    /**
     * 删除专业方向
     * @param ids
     * @return
     */
    void deleteDirection(String[] ids);

    /**
     * 查询专业方向，可根据方向名漫模糊搜索
     * @param direction
     * @param myPageInfo 分页信息
     * @return
     */
    PageInfo<Direction> listDirection(Direction direction, MyPageInfo myPageInfo);

    /**
     * 查看方向介绍
     * @param direction
     * @return
     */
    String getDirectionDetailById(Direction direction);

    Direction getDirectionById(int id);
}
