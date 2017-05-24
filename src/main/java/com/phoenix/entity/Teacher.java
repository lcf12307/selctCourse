package com.phoenix.entity;

/**
 * Created by Phoenix on 2016/12/13.
 */
public class Teacher {

    private String teacherId;

    private String teacherName;

    private String teacherSex;

    private String teacherRanks;

    private String deptId;

    private Integer teacherAuthority;

    private String teacherPassword;

    public Integer getTeacherAuthority() {
        return teacherAuthority;
    }

    public void setTeacherAuthority(Integer teacherAuthority) {
        this.teacherAuthority = teacherAuthority;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherSex() {
        return teacherSex;
    }

    public void setTeacherSex(String teacherSex) {
        this.teacherSex = teacherSex;
    }

    public String getTeacherRanks() {
        return teacherRanks;
    }

    public void setTeacherRanks(String teacherRanks) {
        this.teacherRanks = teacherRanks;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId='" + teacherId + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", teacherSex='" + teacherSex + '\'' +
                ", teacherRanks='" + teacherRanks + '\'' +
                ", deptId='" + deptId + '\'' +
                ", teacherAuthority=" + teacherAuthority +
                '}';
    }

    public Teacher() {
    }

    public Teacher(String teacherId, String teacherName, String teacherSex, String teacherRanks, String deptId, String teacherPassword) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.teacherSex = teacherSex;
        this.teacherRanks = teacherRanks;
        this.deptId = deptId;
        this.teacherPassword = teacherPassword;
    }


    public Teacher(String teacherId, String teacherName, String teacherSex, String teacherRanks, String deptId) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.teacherSex = teacherSex;
        this.teacherRanks = teacherRanks;
        this.deptId = deptId;
    }

    public String getTeacherPassword() {
        return teacherPassword;
    }

    public void setTeacherPassword(String teacherPassword) {
        this.teacherPassword = teacherPassword;
    }
}
