package com.phoenix.entity;

/**
 * Created by Phoenix on 2016/12/20.
 */
public class Teach {

    private String teacherId;

    private String courseId;

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "Teach{" +
                "teacherId='" + teacherId + '\'' +
                ", courseId='" + courseId + '\'' +
                '}';
    }
}
