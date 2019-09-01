package com.lh.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * <p>Description:选课任务表</p>
 *
 * @Author yao
 */
@Data
public class ChoiceTask {

    private Integer id;

    private Integer gradeId;

    private String majorId;

    private String gradeName;

    private String majorName;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    private Date createTime;

    private Date updateTime;

    private String createUsername;

    private boolean deleteFlag;

    private Long startTimeLong;

    private Long endTimeLong;
}
