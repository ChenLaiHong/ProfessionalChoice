package com.lh.pojo;

import cn.afterturn.easypoi.excel.annotation.Excel;

/**
 * Created by laiHom on 2019/8/28.
 */
public class Teacher extends Person{
    @Excel(name = "工号")
    private String loginId;

    @Excel(name = "姓名")
    private String name;


    @Excel(name = "性别",replace ={"男_0","女_1"})
    private Integer gender;



}
