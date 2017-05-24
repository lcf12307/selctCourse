package com.phoenix.dto.Teacher;

import java.util.List;

/**
 * Created by Phoenix on 2016/12/24.
 */
public class AllCourseStudentListItem {

    private String courseName;

    private String courseId;

    private List<StudentListItem> studentListItemList;

    public AllCourseStudentListItem() {
    }

    public AllCourseStudentListItem(String courseName, String courseId, List<StudentListItem> studentListItemList) {
        this.courseName = courseName;
        this.courseId = courseId;
        this.studentListItemList = studentListItemList;
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

    public List<StudentListItem> getStudentListItemList() {
        return studentListItemList;
    }

    public void setStudentListItemList(List<StudentListItem> studentListItemList) {
        this.studentListItemList = studentListItemList;
    }

    @Override
    public String toString() {
        return "AllCourseStudentListItem{" +
                "courseName='" + courseName + '\'' +
                ", courseId='" + courseId + '\'' +
                ", studentListItemList=" + studentListItemList +
                '}';
    }
}
