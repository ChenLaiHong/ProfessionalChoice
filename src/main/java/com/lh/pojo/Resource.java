package com.lh.pojo;

public class Resource {
    private Integer resoureId;

    private String resoureName;

    private String resoureUrl;

    private Integer resourceType;

    private Integer resourceParentId;

    private Integer resourceSort;

    public Integer getResoureId() {
        return resoureId;
    }

    public void setResoureId(Integer resoureId) {
        this.resoureId = resoureId;
    }

    public String getResoureName() {
        return resoureName;
    }

    public void setResoureName(String resoureName) {
        this.resoureName = resoureName == null ? null : resoureName.trim();
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