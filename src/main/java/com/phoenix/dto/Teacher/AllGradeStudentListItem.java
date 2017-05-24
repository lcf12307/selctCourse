package com.phoenix.dto.Teacher;

import java.util.List;

/**
 * Created by Phoenix on 2016/12/25.
 */
public class AllGradeStudentListItem {

    private String courseName;

    private String courseId;

    private List<StudentGradeListItem> studentGradeListItemList;

    public AllGradeStudentListItem() {
    }

    public AllGradeStudentListItem(String courseName, String courseId, List<StudentGradeListItem> studentGradeListItemList) {
        this.courseName = courseName;
        this.courseId = courseId;
        this.studentGradeListItemList = studentGradeListItemList;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public List<StudentGradeListItem> getStudentGradeListItemList() {
        return studentGradeListItemList;
    }

    public void setStudentGradeListItemList(List<StudentGradeListItem> studentGradeListItemList) {
        this.studentGradeListItemList = studentGradeListItemList;
    }

    @Override
    public String toString() {
        return "AllGradeStudentListItem{" +
                "courseName='" + courseName + '\'' +
                ", courseId='" + courseId + '\'' +
                ", studentGradeListItemList=" + studentGradeListItemList +
                '}';
    }
}
