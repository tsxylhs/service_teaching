package com.teach.edu.core.entity;

import java.util.Date;

public class Grade {
    private Long id;

    private Date updatedAt;

    private Date createdAt;

    private Date deletedAt;

    private Long studentId;

    private String courseName;

    private Integer courseGrade;

    private String teachName;

    private Integer grades;

    private Integer testScores;

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

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getCourseGrade() {
        return courseGrade;
    }

    public void setCourseGrade(Integer courseGrade) {
        this.courseGrade = courseGrade;
    }

    public String getTeachName() {
        return teachName;
    }

    public void setTeachName(String teachName) {
        this.teachName = teachName;
    }

    public Integer getGrades() {
        return grades;
    }

    public void setGrades(Integer grades) {
        this.grades = grades;
    }

    public Integer getTestScores() {
        return testScores;
    }

    public void setTestScores(Integer testScores) {
        this.testScores = testScores;
    }
}