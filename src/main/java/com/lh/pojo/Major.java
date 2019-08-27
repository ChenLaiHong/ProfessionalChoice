package com.lh.pojo;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.util.Date;
import java.util.List;

public class Major {
    private Integer majorId;

    @Excel(name = "专业名称")
    private String majorName;

    @Excel(name = "专业代码")
    private String majorCode;

    @Excel(name = "专业学制")
    private Integer majorYear;

    @Excel(name = "专业学费")
    private Integer majorMoney;

    private Integer departmentId;

    private Date updateTime;

    private String personName;

    @Excel(name = "专业介绍",orderNum = "6")
    private String majorDetails;

    private List<Person> personList;

    private Department department;

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

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

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
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

    public Major(Integer majorId, String majorName, String majorCode, Integer majorYear, Integer majorMoney, Integer departmentId, Date updateTime, String personName, String majorDetails, List<Person> personList, Department department) {
        this.majorId = majorId;
        this.majorName = majorName;
        this.majorCode = majorCode;
        this.majorYear = majorYear;
        this.majorMoney = majorMoney;
        this.departmentId = departmentId;
        this.updateTime = updateTime;
        this.personName = personName;
        this.majorDetails = majorDetails;
        this.personList = personList;
        this.department = department;
    }
}