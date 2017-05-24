package com.phoenix.entity;

/**
 * Created by Phoenix on 2016/12/13.
 */
public class Major {

    private String majorId;

    private String deptId;

    private String majorName;

    private String majorIntroduce;

    public String getMajorId() {
        return majorId;
    }

    public void setMajorId(String majorId) {
        this.majorId = majorId;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public String getMajorIntroduce() {
        return majorIntroduce;
    }

    public void setMajorIntroduce(String majorIntroduce) {
        this.majorIntroduce = majorIntroduce;
    }

    @Override
    public String toString() {
        return "Major{" +
                "majorId='" + majorId + '\'' +
                ", deptId='" + deptId + '\'' +
                ", majorName='" + majorName + '\'' +
                ", majorIntroduce='" + majorIntroduce + '\'' +
                '}';
    }
}
