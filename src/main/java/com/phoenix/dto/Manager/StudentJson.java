package com.phoenix.dto.Manager;

/**
 * Created by Phoenix on 2016/12/25.
 */
public class StudentJson {

    private String studentId;

    public StudentJson() {
    }

    public StudentJson(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "StudentJson{" +
                "studentId='" + studentId + '\'' +
                '}';
    }
}
