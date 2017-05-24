package com.phoenix.service.impl;

import com.phoenix.dao.*;
import com.phoenix.dto.CourseListItem;
import com.phoenix.dto.SelectedCourse;
import com.phoenix.dto.StudentGradeItem;
import com.phoenix.entity.*;
import com.phoenix.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Phoenix on 2016/12/21.
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private StuCourseDao stuCourseDao;

    @Autowired
    private TeacherDao teacherDao;

    @Autowired
    private CourseDao courseDao;

    @Autowired
    private TeachDao teachDao;

    @Autowired
    private DeptDao deptDao;


    public List<CourseListItem> getAllCourses(String studentId) {
        List<CourseListItem> allCoursesList = new ArrayList<CourseListItem>();
        List<SelectedCourse> selectedCourseList = this.getSelectedCourse(studentId);
        List<Teach> allTeachList = teachDao.queryAllTeachInfo();

        for(Teach teach : allTeachList) {
            String courseId = teach.getCourseId();
            String courseName = courseDao.queryCourseById(courseId).getCourseName();
            String teacherId = teach.getTeacherId();
            Teacher tmpTeacher = teacherDao.queryTeacherById(teacherId);
            String teacherName = tmpTeacher.getTeacherName();
            Teacher teacherInfo = new Teacher(tmpTeacher.getTeacherId(),tmpTeacher.getTeacherName(), tmpTeacher.getTeacherSex(), tmpTeacher.getTeacherRanks(), tmpTeacher.getDeptId());
            String teacherDeptName = deptDao.queryDeptById(tmpTeacher.getDeptId()).getDeptName();
            int courseTime = courseDao.queryCourseById(courseId).getCourseTime();
            double courseCredie = courseDao.queryCourseById(courseId).getCourseCredit();
            int isSelected = 0;

            for(SelectedCourse selectedCourse : selectedCourseList) {
                if(selectedCourse.getCourseId().equals(courseId) && selectedCourse.getTeacherName().equals(teacherName)) {
                    isSelected = 1;
                    break;
                }
            }

            CourseListItem courseListItem = new CourseListItem(courseId, courseName, teacherName, courseTime, courseCredie, isSelected, teacherInfo, teacherDeptName);
            allCoursesList.add(courseListItem);
        }

        return allCoursesList;
    }

    public List<StudentGradeItem> getGradeList(String studentId) {
        List<StudentGradeItem> studentGradeItemList = new ArrayList<StudentGradeItem>();
        List<StuCourse> selectedCourseList = stuCourseDao.querySelectedCoursesByStudentId(studentId);

        for (StuCourse stuCourse : selectedCourseList) {
            if(!String.valueOf(stuCourse.getStucourseGrade()).equals("0.0")) {
                String courseId = stuCourse.getCourseId();
                String courseName = courseDao.queryCourseById(courseId).getCourseName();
                String teacherId = stuCourse.getTeacherId();
                Teacher tmpTeacher = teacherDao.queryTeacherById(teacherId);
                String teacherName = tmpTeacher.getTeacherName();
                Teacher teacherInfo = new Teacher(tmpTeacher.getTeacherId(),tmpTeacher.getTeacherName(), tmpTeacher.getTeacherSex(), tmpTeacher.getTeacherRanks(), tmpTeacher.getDeptId());
                String teacherDeptName = deptDao.queryDeptById(tmpTeacher.getDeptId()).getDeptName();
                int courseTime = courseDao.queryCourseById(courseId).getCourseTime();
                double coureseCredit = courseDao.queryCourseById(courseId).getCourseCredit();
                double courseGrade = stuCourse.getStucourseGrade();

                StudentGradeItem studentGradeItem = new StudentGradeItem(courseId, courseName, teacherName, courseTime, coureseCredit, courseGrade, teacherInfo, teacherDeptName);
                studentGradeItemList.add(studentGradeItem);
            }
        }
        return studentGradeItemList;
    }

    public List<SelectedCourse> getSelectedCourse(String studentId) {
        List<SelectedCourse> selectedCourseList = new ArrayList<SelectedCourse>();
        List<StuCourse> stuCourseList = stuCourseDao.querySelectedCoursesByStudentId(studentId);

        for (StuCourse stuCourse:stuCourseList) {

            String courseId = stuCourse.getCourseId();
            String courseName = courseDao.queryCourseById(courseId).getCourseName();
            String teacherId = stuCourse.getTeacherId();
            Teacher tmpTeacher = teacherDao.queryTeacherById(teacherId);
            String teacherName = tmpTeacher.getTeacherName();
            Teacher teacherInfo = new Teacher(tmpTeacher.getTeacherId(),tmpTeacher.getTeacherName(), tmpTeacher.getTeacherSex(), tmpTeacher.getTeacherRanks(), tmpTeacher.getDeptId());
            String teacherDeptName = deptDao.queryDeptById(tmpTeacher.getDeptId()).getDeptName();
            int courseTime = courseDao.queryCourseById(courseId).getCourseTime();
            double coureseCredit = courseDao.queryCourseById(courseId).getCourseCredit();

            SelectedCourse selectedCourse = new SelectedCourse(courseId, courseName, teacherName, courseTime, coureseCredit, teacherInfo, teacherDeptName);
            selectedCourseList.add(selectedCourse);
        }

        return selectedCourseList;
    }

    public int excuteSelectCourse(String studentId, String courseId, String teacherId) {
        int result = stuCourseDao.insertSelectedCourse(studentId, courseId, teacherId);
        if(result == 1)
            return 1;
        else
            return 0;
    }

    public int excuteDeleteCourse(String studentId, String courseId, String teacherId) {
        int result = stuCourseDao.deleteSelectedCourseByStudent(studentId, courseId, teacherId);
        if(result == 1)
            return 1;
        else
            return 0;
    }

    public boolean checkIfStudentExist(String studentId) {
        Student result = studentDao.queryById(studentId);
        return null != result;
    }

    public Student queryStudentById(String studentId) {
        return studentDao.queryById(studentId);
    }
}
