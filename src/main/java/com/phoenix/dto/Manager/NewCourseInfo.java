package com.phoenix.dto.Manager;

/**
 * Created by Phoenix on 2016/12/25.
 */
public class NewCourseInfo {

    private String courseId;

    private String courseName;

    private String courseTime;

    private String courseCredit;

    public NewCourseInfo() {
    }

    public NewCourseInfo(String courseId, String courseName, String courseTime, String courseCredit) {
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

    public String getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(String courseTime) {
        this.courseTime = courseTime;
    }

    public String getCourseCredit() {
        return courseCredit;
    }

    public void setCourseCredit(String courseCredit) {
        this.courseCredit = courseCredit;
    }

    @Override
    public String toString() {
        return "NewCourseInfo{" +
                "courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", courseTime='" + courseTime + '\'' +
                ", courseCredit='" + courseCredit + '\'' +
                '}';
    }
}
