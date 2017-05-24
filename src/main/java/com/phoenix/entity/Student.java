package com.phoenix.entity;

/**
 * Created by Phoenix on 2016/12/13.
 */
public class Student {

    private String stuId;

    private String stuName;

    private String stuSex;

    private String majorId;

    private int stuAuthority;

    private String stuPassword;

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuSex() {
        return stuSex;
    }

    public void setStuSex(String stuSex) {
        this.stuSex = stuSex;
    }

    public String getMajorId() {
        return majorId;
    }

    public void setMajorId(String majorId) {
        this.majorId = majorId;
    }

    public int getStuAuthority() {
        return stuAuthority;
    }

    public void setStuAuthority(int stuAuthority) {
        this.stuAuthority = stuAuthority;
    }

    public String getStuPassword() {
        return stuPassword;
    }

    public void setStuPassword(String stuPassword) {
        this.stuPassword = stuPassword;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuId='" + stuId + '\'' +
                ", stuName='" + stuName + '\'' +
                ", stuSex='" + stuSex + '\'' +
                ", majorId='" + majorId + '\'' +
                ", studentAuthority=" + stuAuthority +
                '}';
    }

    public Student(){};

    public Student(String stuId, String stuName, String stuSex, String majorId) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.stuSex = stuSex;
        this.majorId = majorId;
    }

    public Student(String stuId, String stuName, String stuSex, String majorId, String stuPassword) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.stuSex = stuSex;
        this.majorId = majorId;
        this.stuPassword = stuPassword;
    }
}
