package com.phoenix.dto.Manager;

/**
 * Created by Phoenix on 2016/12/25.
 */
public class CourseJson {
    private String courseId;

    public CourseJson() {
    }

    public CourseJson(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "CourseJson{" +
                "courseId='" + courseId + '\'' +
                '}';
    }
}
