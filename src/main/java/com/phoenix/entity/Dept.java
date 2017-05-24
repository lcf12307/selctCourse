package com.phoenix.entity;

/**
 * Created by Phoenix on 2016/12/13.
 */
public class Dept {


    private String deptId;

    private String deptName;

    private String deptIntroduce;

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptIntroduce() {
        return deptIntroduce;
    }

    public void setDeptIntroduce(String deptIntroduce) {
        this.deptIntroduce = deptIntroduce;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptId='" + deptId + '\'' +
                ", deptName='" + deptName + '\'' +
                ", deptIntroduce='" + deptIntroduce + '\'' +
                '}';
    }
}
