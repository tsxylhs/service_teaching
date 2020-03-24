package com.teach.edu.core.entity;

import java.util.Date;

public class Signin {
    private Long id;

    private Date updatedAt;

    private Date createdAt;

    private Date deletedAt;

    private String className;

    private Long studentId;

    private Date startSignin;

    private Date endSignin;

    private String teachName;

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

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Date getStartSignin() {
        return startSignin;
    }

    public void setStartSignin(Date startSignin) {
        this.startSignin = startSignin;
    }

    public Date getEndSignin() {
        return endSignin;
    }

    public void setEndSignin(Date endSignin) {
        this.endSignin = endSignin;
    }

    public String getTeachName() {
        return teachName;
    }

    public void setTeachName(String teachName) {
        this.teachName = teachName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}