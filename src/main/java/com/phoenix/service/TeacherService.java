package com.phoenix.service;

import com.phoenix.dto.Teacher.AllCourseStudentListItem;
import com.phoenix.dto.Teacher.AllGradeStudentListItem;
import com.phoenix.entity.Teacher;

import java.util.List;

/**
 * Created by Phoenix on 2016/12/21.
 */
public interface TeacherService {
    // 成绩录入
    public int updateCourseGrade(String studentId, String courseId, String teacherId, double courseGrade);

    // 查看该老师所教课程
    public List<AllCourseStudentListItem> getTeachCourseStudentList(String teacherId);

    // 获取该老师所教同学成绩表
    public List<AllGradeStudentListItem> getAllStudentGradeList(String teacherId);

    // 查询教师是否存在
    public boolean checkIfTeacherExist(String teacherId);

    // 查询教师
    public Teacher queryTeacherById(String teacherId);
}
