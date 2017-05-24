package com.phoenix.dto.Manager;

/**
 * Created by Phoenix on 2016/12/25.
 */
public class NewStudentInfo {

    private String studentId;

    private String studentName;

    private String studentSex;

    private String majorId;

    public NewStudentInfo() {
    }

    public NewStudentInfo(String studentId, String studentName, String studentSex, String majorId) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentSex = studentSex;
        this.majorId = majorId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentSex() {
        return studentSex;
    }

    public void setStudentSex(String studentSex) {
        this.studentSex = studentSex;
    }

    public String getMajorId() {
        return majorId;
    }

    public void setMajorId(String majorId) {
        this.majorId = majorId;
    }

    @Override
    public String toString() {
        return "NewCourseInfo{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", studentSex='" + studentSex + '\'' +
                ", majorId='" + majorId + '\'' +
                '}';
    }
}
