package com.phoenix.dto.Manager;

/**
 * Created by Phoenix on 2016/12/27.
 */
public class TargetStudentAuthority {

    private int studentAuthority;

    public TargetStudentAuthority() {
    }

    public TargetStudentAuthority(int studentAuthority) {
        this.studentAuthority = studentAuthority;
    }

    public int getStudentAuthority() {
        return studentAuthority;
    }

    public void setStudentAuthority(int studentAuthority) {
        this.studentAuthority = studentAuthority;
    }

    @Override
    public String toString() {
        return "TargetStudentAuthority{" +
                "studentAuthority=" + studentAuthority +
                '}';
    }
}
