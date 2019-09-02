package com.lh.pojo;

import lombok.Data;

import java.util.Date;

/**
 * 学生选课结果
 */
@Data
public class TaskSelected {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 选课任务id
     */
    private Integer taskId;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 选择的方向id
     */
    private Integer directionId;

    /**
     * 选择的方向名
     */
    private String name;

    /**
     * 首次选课时间
     */
    private Date createTime;

    /**
     * 修改选课时间
     */
    private Date updateTime;

    /**
     * 选课开始时间
     */
    private Date startTime;

    /**
     * 选课结束时间
     */
    private Date endTime;

    /**
     * 选课状态
     */
    private String state;

}
