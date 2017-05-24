package com.phoenix.dto.Manager;

/**
 * Created by Phoenix on 2016/12/25.
 */
public class NewTeacherInfo {

    private String teacherId;

    private String deptId;

    private String teacherName;

    private String teacherSex;

    private String teacherRank;

    public NewTeacherInfo() {
    }

    public NewTeacherInfo(String teacherId, String deptId, String teacherName, String teacherSex, String teacherRank) {
        this.teacherId = teacherId;
        this.deptId = deptId;
        this.teacherName = teacherName;
        this.teacherSex = teacherSex;
        this.teacherRank = teacherRank;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
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

    public String getTeacherRank() {
        return teacherRank;
    }

    public void setTeacherRank(String teacherRank) {
        this.teacherRank = teacherRank;
    }

    @Override
    public String toString() {
        return "NewTeacherInfo{" +
                "teacherId='" + teacherId + '\'' +
                ", deptId='" + deptId + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", teacherSex='" + teacherSex + '\'' +
                ", teacherRank='" + teacherRank + '\'' +
                '}';
    }
}
