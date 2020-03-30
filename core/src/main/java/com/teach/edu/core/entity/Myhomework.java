package com.teach.edu.core.entity;

import java.util.Date;

public class Myhomework {
    private Long id;

    private Date updatedAt;

    private Date createdAt;

    private Date deletedAt;

    private Long homeworkId;

    private String homeworkUrl;

    private String homeworkDesc;

    private String homeworkStatus;

    private Long userId;

    private String userName;

    private String className;

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

    public Long getHomeworkId() {
        return homeworkId;
    }

    public void setHomeworkId(Long homeworkId) {
        this.homeworkId = homeworkId;
    }

    public String getHomeworkUrl() {
        return homeworkUrl;
    }

    public void setHomeworkUrl(String homeworkUrl) {
        this.homeworkUrl = homeworkUrl;
    }

    public String getHomeworkDesc() {
        return homeworkDesc;
    }

    public void setHomeworkDesc(String homeworkDesc) {
        this.homeworkDesc = homeworkDesc;
    }

    public String getHomeworkStatus() {
        return homeworkStatus;
    }

    public void setHomeworkStatus(String homeworkStatus) {
        this.homeworkStatus = homeworkStatus;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}