package com.phoenix.dto.Teacher;

/**
 * Created by Phoenix on 2016/12/25.
 */
public class StudentGradeListItem {

    private String studentId;

    private String studentName;

    private String studentSex;

    private String majorName;

    private String deptName;

    private double studentGrade;

    public StudentGradeListItem() {
    }

    public StudentGradeListItem(String studentId, String studentName, String studentSex, String majorName, String deptName, double studentGrade) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentSex = studentSex;
        this.majorName = majorName;
        this.deptName = deptName;
        this.studentGrade = studentGrade;
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

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public double getStudentGrade() {
        return studentGrade;
    }

    public void setStudentGrade(double studentGrade) {
        this.studentGrade = studentGrade;
    }

    @Override
    public String toString() {
        return "StudentGradeListItem{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", studentSex='" + studentSex + '\'' +
                ", majorName='" + majorName + '\'' +
                ", deptName='" + deptName + '\'' +
                ", studentGrade=" + studentGrade +
                '}';
    }
}
