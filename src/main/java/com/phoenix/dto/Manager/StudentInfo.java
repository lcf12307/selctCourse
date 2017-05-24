package com.phoenix.dto.Manager;

/**
 * Created by Phoenix on 2016/12/25.
 */
public class StudentInfo {

    private String studentId;

    private String studentName;

    private String studentSex;

    private String majorName;

    public StudentInfo() {
    }

    public StudentInfo(String studentId, String studentName, String studentSex, String majorName) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentSex = studentSex;
        this.majorName = majorName;
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

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    @Override
    public String toString() {
        return "StudentInfo{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", studentSex='" + studentSex + '\'' +
                ", majorName='" + majorName + '\'' +
                '}';
    }
}
