package com.phoenix.dto.Manager;

/**
 * Created by Phoenix on 2016/12/26.
 */
public class DeptInfoJson {

    private String deptId;

    private String deptName;

    public DeptInfoJson() {
    }

    public DeptInfoJson(String deptId, String deptName) {
        this.deptId = deptId;
        this.deptName = deptName;
    }

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

    @Override
    public String toString() {
        return "DeptInfoJson{" +
                "deptId='" + deptId + '\'' +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}
