package com.lh.pojo;

public class Resource {
    private Integer resoureId;

    private String name;

    private String resoureUrl;

    private Integer resourceType;

    private Integer resourceParentId;

    private Integer resourceSort;

    private String checked;//是否选中

    public String getChecked() {
        return checked;
    }

    public void setChecked(String checked) {
        this.checked = checked;
    }

    public Integer getResoureId() {
        return resoureId;
    }

    public void setResoureId(Integer resoureId) {
        this.resoureId = resoureId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getResoureUrl() {
        return resoureUrl;
    }

    public void setResoureUrl(String resoureUrl) {
        this.resoureUrl = resoureUrl == null ? null : resoureUrl.trim();
    }

    public Integer getResourceType() {
        return resourceType;
    }

    public void setResourceType(Integer resourceType) {
        this.resourceType = resourceType;
    }

    public Integer getResourceParentId() {
        return resourceParentId;
    }

    public void setResourceParentId(Integer resourceParentId) {
        this.resourceParentId = resourceParentId;
    }

    public Integer getResourceSort() {
        return resourceSort;
    }

    public void setResourceSort(Integer resourceSort) {
        this.resourceSort = resourceSort;
    }
}