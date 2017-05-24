package com.phoenix.dto.Teacher;

/**
 * Created by Phoenix on 2016/12/24.
 */
public class StudentListItem {

    private String studentId;

    private String studentName;

    private String studentSex;

    private String majorName;

    private String deptName;

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

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public StudentListItem() {
    }

    public StudentListItem(String studentId, String studentName, String studentSex, String majorName, String deptName) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentSex = studentSex;
        this.majorName = majorName;
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "StudentListItem{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", studentSex='" + studentSex + '\'' +
                ", majorName='" + majorName + '\'' +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}
