package com.phoenix.dto;

/**
 * Created by Phoenix on 2016/12/24.
 */
public class QuitOrSelectCourseItem {

    private String studentId;

    private String courseId;

    private String teacherId;

    public QuitOrSelectCourseItem() {
    }

    public QuitOrSelectCourseItem(String studentId, String courseId, String teacherId) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.teacherId = teacherId;
    }

    @Override
    public String toString() {
        return "QuitOrSelectCourseItem{" +
                "studentId='" + studentId + '\'' +
                ", courseId='" + courseId + '\'' +
                ", teacherId='" + teacherId + '\'' +
                '}';
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
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
}
