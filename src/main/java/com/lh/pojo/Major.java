package com.lh.pojo;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.util.Date;

public class Major {
    private Integer majorId;

    @Excel(name = "专业名称",orderNum = "1")
    private String majorName;

    @Excel(name = "专业代码",orderNum = "2")
    private String majorCode;

    @Excel(name = "专业学制",orderNum = "3")
    private Integer majorYear;

    @Excel(name = "专业学费",orderNum = "4")
    private Integer majorMoney;

    @Excel(name = "专业院系",orderNum = "5")
    private String departmentName;

    private Date selectTime;

    private Date updateTime;

    private String personName;

    @Excel(name = "专业介绍",orderNum = "6")
    private String majorDetails;

    public Integer getMajorId() {
        return majorId;
    }

    public void setMajorId(Integer majorId) {
        this.majorId = majorId;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName == null ? null : majorName.trim();
    }

    public String getMajorCode() {
        return majorCode;
    }

    public void setMajorCode(String majorCode) {
        this.majorCode = majorCode == null ? null : majorCode.trim();
    }

    public Integer getMajorYear() {
        return majorYear;
    }

    public void setMajorYear(Integer majorYear) {
        this.majorYear = majorYear;
    }

    public Integer getMajorMoney() {
        return majorMoney;
    }

    public void setMajorMoney(Integer majorMoney) {
        this.majorMoney = majorMoney;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName == null ? null : departmentName.trim();
    }

    public Date getSelectTime() {
        return selectTime;
    }

    public void setSelectTime(Date selectTime) {
        this.selectTime = selectTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName == null ? null : personName.trim();
    }

    public String getMajorDetails() {
        return majorDetails;
    }

    public void setMajorDetails(String majorDetails) {
        this.majorDetails = majorDetails == null ? null : majorDetails.trim();
    }

    public Major() {
    }

    public Major(Integer majorId, String majorName, String majorCode, Integer majorYear, Integer majorMoney, String departmentName, Date selectTime, Date updateTime, String personName, String majorDetails) {
        this.majorId = majorId;
        this.majorName = majorName;
        this.majorCode = majorCode;
        this.majorYear = majorYear;
        this.majorMoney = majorMoney;
        this.departmentName = departmentName;
        this.selectTime = selectTime;
        this.updateTime = updateTime;
        this.personName = personName;
        this.majorDetails = majorDetails;
    }
}