package com.phoenix.service;

import com.phoenix.dto.CourseListItem;
import com.phoenix.dto.SelectedCourse;
import com.phoenix.dto.StudentGradeItem;
import com.phoenix.entity.Student;

import java.util.List;

/**
 * Created by Phoenix on 2016/12/21.
 */
public interface StudentService {

    // 查看已选课程
    public List<SelectedCourse> getSelectedCourse(String studentId);

    // 选课
    public int excuteSelectCourse(String studentId, String courseId, String teacherId);

    // 退课
    public int excuteDeleteCourse(String studentId, String courseId, String teacherId);

    // 查询是否存在
    public boolean checkIfStudentExist(String studentId);

    // 查询学生
    public Student queryStudentById(String studentId);

    // 查询全部课程
    public List<CourseListItem> getAllCourses(String studentId);

    // 查询成绩
    public List<StudentGradeItem> getGradeList(String studentId);

}
