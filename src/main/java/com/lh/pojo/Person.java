package com.lh.pojo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import org.springframework.stereotype.Component;

@Component
public class Person {
    @Excel(name = "学号")
    private String loginId;

    @Excel(name = "姓名")
    private String name;

    private String password;

    @Excel(name = "班级")
    private String grades;

    @Excel(name = "性别",replace ={"男_0","女_1"})
    private Integer gender;

    @Excel(name = "联系电话")
    private String phone;

    private Integer majorId;

    private Major major;

    private Grade grade;

    private Integer gradeId;

    private Integer personStatic;

    @Excel(name = "联系qq")
    private String qqNumber;

    private Integer enrollmentYear;

    @Excel(name = "邮箱")
    private String email;

    @Excel(name = "学籍状态",replace = {"无学籍_0","有学籍_1"})
    private Integer studentStatus;

    private Integer staticLive;

    private Integer roleId;

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId == null ? null : loginId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getGrades() {
        return grades;
    }

    public void setGrades(String grades) {
        this.grades = grades == null ? null : grades.trim();
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getMajorId() {
        return majorId;
    }

    public void setMajorId(Integer majorId) {
        this.majorId = majorId;
    }

    public Integer getGradeId() {
        return gradeId;
    }

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }

    public Integer getPersonStatic() {
        return personStatic;
    }

    public void setPersonStatic(Integer personStatic) {
        this.personStatic = personStatic;
    }

    public String getQqNumber() {
        return qqNumber;
    }

    public void setQqNumber(String qqNumber) {
        this.qqNumber = qqNumber == null ? null : qqNumber.trim();
    }

    public Integer getEnrollmentYear() {
        return enrollmentYear;
    }

    public void setEnrollmentYear(Integer enrollmentYear) {
        this.enrollmentYear = enrollmentYear;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getStudentStatus() {
        return studentStatus;
    }

    public void setStudentStatus(Integer studentStatus) {
        this.studentStatus = studentStatus;
    }

    public Integer getStaticLive() {
        return staticLive;
    }

    public void setStaticLive(Integer staticLive) {
        this.staticLive = staticLive;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Person() {
    }

    public Person(String loginId, String name, String password, String grades, Integer gender, String phone, Integer majorId, Major major, Grade grade, Integer gradeId, Integer personStatic, String qqNumber, Integer enrollmentYear, String email, Integer studentStatus, Integer staticLive, Integer roleId) {
        this.loginId = loginId;
        this.name = name;
        this.password = password;
        this.grades = grades;
        this.gender = gender;
        this.phone = phone;
        this.majorId = majorId;
        this.major = major;
        this.grade = grade;
        this.gradeId = gradeId;
        this.personStatic = personStatic;
        this.qqNumber = qqNumber;
        this.enrollmentYear = enrollmentYear;
        this.email = email;
        this.studentStatus = studentStatus;
        this.staticLive = staticLive;
        this.roleId = roleId;
    }
}