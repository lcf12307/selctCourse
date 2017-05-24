package com.phoenix.service.impl;

import com.phoenix.dao.*;
import com.phoenix.dto.Manager.*;
import com.phoenix.entity.*;
import com.phoenix.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Phoenix on 2016/12/21.
 */
@Service
public class ManagerServiceImpl implements ManagerService{

    @Autowired
    private TeacherDao teacherDao;

    @Autowired
    private CourseDao courseDao;

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private TeachDao teachDao;

    @Autowired
    private StuCourseDao stuCourseDao;

    @Autowired
    private DeptDao deptDao;

    @Autowired
    private MajorDao majorDao;

    @Autowired
    private ManagerDao managerDao;

    public boolean checkIfManagerExist(String managerId) {
        Manager result = managerDao.queryManagerById(managerId);
        return null != result;
    }

    public Manager queryManagerById(String managerId) {
        Manager manager = managerDao.queryManagerById(managerId);
        return manager;
    }

    public int insertTeacher(Teacher teacher) {
        int result = teacherDao.insertTeacher(teacher);
        if(result == 1) {
            return 1;
        }
        return 0;
    }

    public int deleteTeacher(String teacherId) {
        int result = teachDao.deleteByTeacherId(teacherId);
        result &= stuCourseDao.deleteByTeacherId(teacherId);
        result &= teacherDao.deleteTeacherById(teacherId);
        if(result==0) return 0;
        return 1;
    }

    public int insertStudent(Student student) {
        int result = studentDao.insertStudent(student);
        if(result == 1) {
            return 1;
        }
        return 0;
    }

    public int deleteStudent(String studentId) {
        int result = stuCourseDao.deleteByStudentId(studentId);
        result &= studentDao.deleteStudentById(studentId);
        if(result==0) return 0;
        return 1;
    }

    public int insertCourse(Course course) {
        int result = courseDao.insertCourse(course);
        if(result == 1) {
            return 1;
        }
        return 0;
    }

    public int deleteCourse(String courseId) {
        int result = stuCourseDao.deleteByCourseId(courseId);
        result &= teachDao.deleteByCourseId(courseId);
        result &= courseDao.deleteCourseById(courseId);
        if(result==0) return 0;
        return 1;
    }

    public List<StudentInfo> getAllStudentList() {
        List<Student> studentList = studentDao.queryAllStudent();
        List<StudentInfo> studentInfoList = new ArrayList<StudentInfo>();
        for (Student student : studentList) {
            String studentId = student.getStuId();
            String studentName = student.getStuName();
            String studentSex = student.getStuSex();
            String majorName = majorDao.queryMajorById(student.getMajorId()).getMajorName();
            StudentInfo studentInfo = new StudentInfo(studentId, studentName, studentSex, majorName);
            studentInfoList.add(studentInfo);
        }
        return studentInfoList;
    }

    public List<TeacherInfo> getAllTeacherList() {
        List<Teacher> teacherList = teacherDao.queryAllTeacher();
        List<TeacherInfo> teacherInfoList = new ArrayList<TeacherInfo>();
        for(Teacher teacher : teacherList) {
            String teacherId = teacher.getTeacherId();
            String teacherName = teacher.getTeacherName();
            String teacherSex = teacher.getTeacherSex();
            String deptName = deptDao.queryDeptById(teacher.getDeptId()).getDeptName();
            String teacherRank = teacher.getTeacherRanks();
            TeacherInfo teacherInfo = new TeacherInfo(teacherId, teacherName, teacherSex, deptName, teacherRank);
            teacherInfoList.add(teacherInfo);
        }
        return teacherInfoList;
    }

    public List<CourseInfo> getAllCourseList() {
        List<Course> courseList = courseDao.queryAllCourses();
        List<CourseInfo> courseInfoList = new ArrayList<CourseInfo>();
        for(Course course : courseList) {
            String courseId = course.getCourseId();
            String courseName = course.getCourseName();
            int courseTime = course.getCourseTime();
            double courseCredit = course.getCourseCredit();
            CourseInfo courseInfo = new CourseInfo(courseId, courseName, courseTime, courseCredit);
            courseInfoList.add(courseInfo);
        }
        return  courseInfoList;
    }

    public List<MajorInfoJson> getAllMajorList() {
        List<Major> majorList = majorDao.getAllMajor();
        List<MajorInfoJson> majorInfoJsonList = new ArrayList<MajorInfoJson>();
        for(Major major : majorList) {
            MajorInfoJson majorInfoJson = new MajorInfoJson(major.getMajorId(), major.getMajorName());
            majorInfoJsonList.add(majorInfoJson);
        }
        return  majorInfoJsonList;
    }

    public List<DeptInfoJson> getAllDeptList() {
        List<Dept> deptList = deptDao.getAllDept();
        List<DeptInfoJson> deptInfoJsonList = new ArrayList<DeptInfoJson>();
        for(Dept dept : deptList) {
            DeptInfoJson deptInfoJson = new DeptInfoJson(dept.getDeptId(), dept.getDeptName());
            deptInfoJsonList.add(deptInfoJson);
        }
        return deptInfoJsonList;
    }

    public int updateStudentSelectAuthority(int authority) {
        int result = studentDao.updateAllAuthority(authority);
        return result == 0 ? 0 : 1;
    }
}
