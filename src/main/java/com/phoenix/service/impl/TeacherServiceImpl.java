package com.phoenix.service.impl;

import com.phoenix.dao.*;
import com.phoenix.dto.Teacher.AllCourseStudentListItem;
import com.phoenix.dto.Teacher.AllGradeStudentListItem;
import com.phoenix.dto.Teacher.StudentGradeListItem;
import com.phoenix.dto.Teacher.StudentListItem;
import com.phoenix.entity.*;
import com.phoenix.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Phoenix on 2016/12/21.
 */
@Service
public class TeacherServiceImpl implements TeacherService{

    @Autowired
    private TeacherDao teacherDao;

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private TeachDao teachDao;

    @Autowired
    private StuCourseDao stuCourseDao;

    @Autowired
    private MajorDao majorDao;

    @Autowired
    private DeptDao deptDao;

    @Autowired
    private CourseDao courseDao;

    public int updateCourseGrade(String studentId, String courseId, String teacherId, double courseGrade) {
        int result = stuCourseDao.updateStudentGrade(studentId, courseId, teacherId, courseGrade);
        return result;
    }

    public List<AllGradeStudentListItem> getAllStudentGradeList(String teacherId) {
        List<AllGradeStudentListItem> allGradeStudentListItemList = new ArrayList<AllGradeStudentListItem>();
        List<Teach> teachList = teachDao.queryTeachByTeacherId(teacherId);
        for (Teach teachCourseItem : teachList) {
            String courseId = teachCourseItem.getCourseId();
            String courseName = courseDao.queryCourseById(courseId).getCourseName();
            List<StuCourse> stuCourseList = stuCourseDao.querySelectedCoursesByTeacherId(teacherId, courseId);
            List<StudentGradeListItem> studentGradeListItemList = new ArrayList<StudentGradeListItem>();
            for(StuCourse stuCourse : stuCourseList) {
                String studentId = stuCourse.getStuId();
                Student student = studentDao.queryById(studentId);
                String studentName = student.getStuName();
                String studentSex = student.getStuSex();
                String majorId = student.getMajorId();
                String majorName = majorDao.queryMajorById(majorId).getMajorName();
                String deptName = deptDao.queryDeptById(majorDao.queryMajorById(majorId).getDeptId()).getDeptName();
                double studentGrade = stuCourse.getStucourseGrade();
                StudentGradeListItem studentListItem = new StudentGradeListItem(studentId, studentName, studentSex, majorName, deptName, studentGrade);
                studentGradeListItemList.add(studentListItem);
            }
            AllGradeStudentListItem allCourseStudentListItem = new AllGradeStudentListItem(courseName, courseId, studentGradeListItemList);
            allGradeStudentListItemList.add(allCourseStudentListItem);
        }
        return allGradeStudentListItemList;
    }

    public List<AllCourseStudentListItem> getTeachCourseStudentList(String teacherId) {
        List<AllCourseStudentListItem> allCourseStudentListItemList = new ArrayList<AllCourseStudentListItem>();
        List<Teach> teachList = teachDao.queryTeachByTeacherId(teacherId);
        for (Teach teachCourseItem : teachList) {
            String courseId = teachCourseItem.getCourseId();
            String courseName = courseDao.queryCourseById(courseId).getCourseName();
            List<StuCourse> stuCourseList = stuCourseDao.querySelectedCoursesByTeacherId(teacherId, courseId);
            List<StudentListItem> studentListItemList = new ArrayList<StudentListItem>();
            for(StuCourse stuCourse : stuCourseList) {
                String studentId = stuCourse.getStuId();
                Student student = studentDao.queryById(studentId);
                String studentName = student.getStuName();
                String studentSex = student.getStuSex();
                String majorId = student.getMajorId();
                String majorName = majorDao.queryMajorById(majorId).getMajorName();
                String deptName = deptDao.queryDeptById(majorDao.queryMajorById(majorId).getDeptId()).getDeptName();
                StudentListItem studentListItem = new StudentListItem(studentId, studentName, studentSex, majorName, deptName);
                studentListItemList.add(studentListItem);
            }
            AllCourseStudentListItem allCourseStudentListItem = new AllCourseStudentListItem(courseName, courseId, studentListItemList);
            allCourseStudentListItemList.add(allCourseStudentListItem);
        }
        return allCourseStudentListItemList;
    }

    public boolean checkIfTeacherExist(String teacherId) {
        Teacher result = teacherDao.queryTeacherById(teacherId);
        return null != result;
    }

    public Teacher queryTeacherById(String teacherId) {
        return teacherDao.queryTeacherById(teacherId);
    }
}
