package com.phoenix.entity;

/**
 * Created by Phoenix on 2016/12/13.
 */
public class StuCourse {

    private String stuId;

    private String courseId;

    private String teacherId;

    private double stucourseGrade;

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public double getStucourseGrade() {
        return stucourseGrade;
    }

    public void setStucourseGrade(double stucourseGrade) {
        this.stucourseGrade = stucourseGrade;
    }

    public StuCourse() {
    }

    public StuCourse(String stuId, String courseId, String teacherId, double stucourseGrade) {
        this.stuId = stuId;
        this.courseId = courseId;
        this.teacherId = teacherId;
        this.stucourseGrade = stucourseGrade;
    }

    public StuCourse(String stuId, String courseId, String teacherId) {
        this.stuId = stuId;
        this.courseId = courseId;
        this.teacherId = teacherId;
    }

    @Override
    public String toString() {
        return "StuCourse{" +
                "stuId='" + stuId + '\'' +
                ", courseId='" + courseId + '\'' +
                ", teacherId='" + teacherId + '\'' +
                ", stucourseGrade=" + stucourseGrade +
                '}';
    }
}
