package com.phoenix.dto.Manager;

/**
 * Created by Phoenix on 2016/12/25.
 */
public class CourseInfo {

    private String courseId;

    private String courseName;

    private int courseTime;

    private double courseCredit;

    public CourseInfo() {
    }

    public CourseInfo(String courseId, String courseName, int courseTime, double courseCredit) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseTime = courseTime;
        this.courseCredit = courseCredit;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(int courseTime) {
        this.courseTime = courseTime;
    }

    public double getCourseCredit() {
        return courseCredit;
    }

    public void setCourseCredit(double courseCredit) {
        this.courseCredit = courseCredit;
    }

    @Override
    public String toString() {
        return "CourseInfo{" +
                "courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", courseTime=" + courseTime +
                ", courseCredit=" + courseCredit +
                '}';
    }
}
