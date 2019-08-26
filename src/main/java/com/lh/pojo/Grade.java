package com.lh.pojo;

import java.util.List;

public class Grade {
    private Integer gradeId;

    private String gradeName;

    private Integer gradeState;

    private List<Person> personList;

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public Integer getGradeId() {
        return gradeId;
    }

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName == null ? null : gradeName.trim();
    }

    public Integer getGradeState() {
        return gradeState;
    }

    public void setGradeState(Integer gradeState) {
        this.gradeState = gradeState;
    }

    public Grade() {
    }

    public Grade(Integer gradeId, String gradeName, Integer gradeState, List<Person> personList) {
        this.gradeId = gradeId;
        this.gradeName = gradeName;
        this.gradeState = gradeState;
        this.personList = personList;
    }
}