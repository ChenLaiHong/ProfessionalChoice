package com.lh.pojo;

import cn.afterturn.easypoi.excel.annotation.Excel;

/**
 * Created by laiHom on 2019/8/28.
 */
public class Teacher{
    @Excel(name = "工号")
    private String loginId;

    @Excel(name = "姓名")
    private String name;


    @Excel(name = "性别",replace ={"男_0","女_1"})
    private Integer gender;

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }
}
