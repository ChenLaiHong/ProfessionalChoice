package com.lh.pojo;

import lombok.Data;

import java.util.Date;

/**
 * 专业方向表
 */
@Data
public class Direction {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 方向名
     */
    private String name;

    /**
     * 方向介绍
     */
    private String details;

    /**
     * 操作用户名
     */
    private String operationUsername;

    /**
     * 方向所属的专业id
     */
    private Integer majorId;

    /**
     * 方向所属的年级Id
     */
    private Integer gradeId;

    /**
     * 年级名
     */
    private String gradeName;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 方向是否删除的标志
     */
    private boolean deleteFlag;

    /**
     * 限选人数
     */
    private Integer limitNumber;

    /**
     * 已选人数
     */
    private Integer selectedNumber;
}
