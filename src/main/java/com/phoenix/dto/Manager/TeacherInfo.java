package com.phoenix.dto.Manager;

/**
 * Created by Phoenix on 2016/12/25.
 */
public class TeacherInfo {

    private String teacherId;

    private String teahcerName;

    private String teacherSex;

    private String deptName;

    private String teacherRank;

    public TeacherInfo() {
    }

    public TeacherInfo(String teacherId, String teahcerName, String teacherSex, String deptName, String teacherRank) {
        this.teacherId = teacherId;
        this.teahcerName = teahcerName;
        this.teacherSex = teacherSex;
        this.deptName = deptName;
        this.teacherRank = teacherRank;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeahcerName() {
        return teahcerName;
    }

    public void setTeahcerName(String teahcerName) {
        this.teahcerName = teahcerName;
    }

    public String getTeacherSex() {
        return teacherSex;
    }

    public void setTeacherSex(String teacherSex) {
        this.teacherSex = teacherSex;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getTeacherRank() {
        return teacherRank;
    }

    public void setTeacherRank(String teacherRank) {
        this.teacherRank = teacherRank;
    }

    @Override
    public String toString() {
        return "TeacherInfo{" +
                "teacherId='" + teacherId + '\'' +
                ", teahcerName='" + teahcerName + '\'' +
                ", teacherSex='" + teacherSex + '\'' +
                ", deptName='" + deptName + '\'' +
                ", teacherRank='" + teacherRank + '\'' +
                '}';
    }
}
