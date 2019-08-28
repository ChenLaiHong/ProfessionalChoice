package com.lh.pojo;

import java.util.List;

public class Role {
    private Integer roleId;

    private String roleName;

    private List<Person> personList;

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public Role() {
    }

    public Role(Integer roleId, String roleName, List<Person> personList) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.personList = personList;
    }
}