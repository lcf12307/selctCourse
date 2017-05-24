package com.phoenix.dto;

/**
 * Created by Phoenix on 2016/12/22.
 */
public class SelectedCourseStudent {

    private String stuId;

    private String stuName;

    private String stuSex;

    private String stuDeptName;

    private String stuMajorName;

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

    public String getStuDeptName() {
        return stuDeptName;
    }

    public void setStuDeptName(String stuDeptName) {
        this.stuDeptName = stuDeptName;
    }

    public String getStuMajorName() {
        return stuMajorName;
    }

    public void setStuMajorName(String stuMajorName) {
        this.stuMajorName = stuMajorName;
    }

    public SelectedCourseStudent(String stuId, String stuName, String stuSex, String stuDeptName, String stuMajorName) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.stuSex = stuSex;
        this.stuDeptName = stuDeptName;
        this.stuMajorName = stuMajorName;
    }

    @Override
    public String toString() {
        return "SelectedCourseStudent{" +
                "stuId='" + stuId + '\'' +
                ", stuName='" + stuName + '\'' +
                ", stuSex='" + stuSex + '\'' +
                ", stuDeptName='" + stuDeptName + '\'' +
                ", stuMajorName='" + stuMajorName + '\'' +
                '}';
    }
}
