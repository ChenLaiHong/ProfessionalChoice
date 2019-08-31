package com.lh.pojo;

public class Image {
    private String personId;

    private String personPhoto;

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId == null ? null : personId.trim();
    }

    public String getPersonPhoto() {
        return personPhoto;
    }

    public void setPersonPhoto(String personPhoto) {
        this.personPhoto = personPhoto == null ? null : personPhoto.trim();
    }
}