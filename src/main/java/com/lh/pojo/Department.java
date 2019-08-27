package com.lh.pojo;

import java.util.List;

public class Department {
    private Integer departmentId;

    private String departmentName;

    private List<Major> majorList;

    public List<Major> getMajorList() {
        return majorList;
    }

    public void setMajorList(List<Major> majorList) {
        this.majorList = majorList;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName == null ? null : departmentName.trim();
    }

    public Department() {
    }

    public Department(Integer departmentId, String departmentName, List<Major> majorList) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.majorList = majorList;
    }
}