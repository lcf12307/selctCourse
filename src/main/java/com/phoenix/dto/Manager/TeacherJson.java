package com.phoenix.dto.Manager;

/**
 * Created by Phoenix on 2016/12/25.
 */
public class TeacherJson {

    private String teacherId;

    public TeacherJson() {
    }

    public TeacherJson(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public String toString() {
        return "TeacherJson{" +
                "teacherId='" + teacherId + '\'' +
                '}';
    }
}