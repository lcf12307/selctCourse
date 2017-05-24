package com.phoenix.dto;

import com.phoenix.entity.Teacher;

/**
 * Created by Phoenix on 2016/12/24.
 */
public class StudentGradeItem {

    // 课程编号
    private String courseId;

    // 课程名称
    private String courseName;

    // 授课老师名
    private String teacherName;

    // 课程时长
    private int coureTime;

    // 课程学分
    private double courseCredit;

    // 课程成绩
    private double courseGrade;

    // 教师信息
    private Teacher teacherInfo;

    // 教师学院
    private String teacherDeptName;

    public StudentGradeItem() {
    }

    public StudentGradeItem(String courseId, String courseName, String teacherName, int coureTime, double courseCredit, double courseGrade, Teacher teacherInfo, String teacherDeptName) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.teacherName = teacherName;
        this.coureTime = coureTime;
        this.courseCredit = courseCredit;
        this.courseGrade = courseGrade;
        this.teacherInfo = teacherInfo;
        this.teacherDeptName = teacherDeptName;
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

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public int getCoureTime() {
        return coureTime;
    }

    public void setCoureTime(int coureTime) {
        this.coureTime = coureTime;
    }

    public double getCourseCredit() {
        return courseCredit;
    }

    public void setCourseCredit(double courseCredit) {
        this.courseCredit = courseCredit;
    }

    public double getCourseGrade() {
        return courseGrade;
    }

    public void setCourseGrade(double courseGrade) {
        this.courseGrade = courseGrade;
    }

    public Teacher getTeacherInfo() {
        return teacherInfo;
    }

    public void setTeacherInfo(Teacher teacherInfo) {
        this.teacherInfo = teacherInfo;
    }

    public String getTeacherDeptName() {
        return teacherDeptName;
    }

    public void setTeacherDeptName(String teacherDeptName) {
        this.teacherDeptName = teacherDeptName;
    }

    @Override
    public String toString() {
        return "StudentGradeItem{" +
                "courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", coureTime=" + coureTime +
                ", courseCredit=" + courseCredit +
                ", courseGrade=" + courseGrade +
                ", teacherInfo=" + teacherInfo +
                ", teacherDeptName='" + teacherDeptName + '\'' +
                '}';
    }
}
