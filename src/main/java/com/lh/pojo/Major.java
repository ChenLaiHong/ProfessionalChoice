package com.lh.pojo;

import java.util.Date;

public class Major {
    private Integer majorId;

    private String majorName;

    private String majorCode;

    private Integer majorYear;

    private Integer majorMoney;

    private String departmentName;

    private Date selectTime;

    private Date updateTime;

    private String personName;

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
}