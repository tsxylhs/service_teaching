package com.teach.edu.core.entity;

import java.util.Date;

public class Materials {
    private Long id;

    private Date updatedAt;

    private Date createdAt;

    private Date deletedAt;

    private String materialsUrl;

    private String materialsDesc;

    private String category;

    private String courseName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    public String getMaterialsUrl() {
        return materialsUrl;
    }

    public void setMaterialsUrl(String materialsUrl) {
        this.materialsUrl = materialsUrl;
    }

    public String getMaterialsDesc() {
        return materialsDesc;
    }

    public void setMaterialsDesc(String materialsDesc) {
        this.materialsDesc = materialsDesc;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}