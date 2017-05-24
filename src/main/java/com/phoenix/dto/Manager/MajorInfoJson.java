package com.phoenix.dto.Manager;

/**
 * Created by Phoenix on 2016/12/26.
 */
public class MajorInfoJson {

    private String majorId;

    private String majorName;

    public MajorInfoJson() {
    }

    public MajorInfoJson(String majorId, String majorName) {
        this.majorId = majorId;
        this.majorName = majorName;
    }

    public String getMajorId() {
        return majorId;
    }

    public void setMajorId(String majorId) {
        this.majorId = majorId;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    @Override
    public String toString() {
        return "MajorInfoJson{" +
                "majorId='" + majorId + '\'' +
                ", majorName='" + majorName + '\'' +
                '}';
    }
}
