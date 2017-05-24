package com.phoenix.dto.Teacher;

/**
 * Created by Phoenix on 2016/12/25.
 */
public class UpdateCourseJson {
    private String studentId;
    private String courseId;
    private String teacherId;
    private String grade;

    public UpdateCourseJson() {
    }

    public UpdateCourseJson(String studentId, String courseId, String teacherId, String grade) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.teacherId = teacherId;
        this.grade = grade;
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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "UpdateCourseJson{" +
                "studentId='" + studentId + '\'' +
                ", courseId='" + courseId + '\'' +
                ", teacherId='" + teacherId + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}
