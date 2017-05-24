package com.phoenix.service;

import com.phoenix.dto.Manager.*;
import com.phoenix.entity.Course;
import com.phoenix.entity.Manager;
import com.phoenix.entity.Student;
import com.phoenix.entity.Teacher;

import java.util.List;

/**
 * Created by Phoenix on 2016/12/21.
 */
public interface ManagerService {

    // 添加教师
    public int insertTeacher(Teacher teacher);

    // 删除教师
    public int deleteTeacher(String teacherId);

    // 添加学生
    public int insertStudent(Student student);

    // 删除学生
    public int deleteStudent(String studentId);

    // 添加课程
    public int insertCourse(Course course);

    // 删除课程
    public int deleteCourse(String courseId);

    // 获取全部学生信息
    public List<StudentInfo> getAllStudentList();

    // 获取全部教师名单
    public List<TeacherInfo> getAllTeacherList();

    // 获取全部课程信息
    public List<CourseInfo> getAllCourseList();

    // 查询管理员是否存在
    public boolean checkIfManagerExist(String managerId);

    // 查询管理员
    public Manager queryManagerById(String managerId);

    // 查询全部专业
    public List<MajorInfoJson> getAllMajorList();

    // 查询全部系信息
    public List<DeptInfoJson> getAllDeptList();

    // 更改学生选课权限
    public int updateStudentSelectAuthority(int authority);
}
