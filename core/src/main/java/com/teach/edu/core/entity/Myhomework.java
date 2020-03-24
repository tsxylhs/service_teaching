package com.teach.edu.core.entity;

import java.util.Date;

public class Myhomework {
    private Long id;

    private Date updatedAt;

    private Date createdAt;

    private Date deletedAt;

    private Long homeworkId;

    private Long homeworkUrl;

    private String homeworkDesc;

    private String homeworkStatus;

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

    public Long getHomeworkUrl() {
        return homeworkUrl;
    }

    public void setHomeworkUrl(Long homeworkUrl) {
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
}