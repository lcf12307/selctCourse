package com.phoenix.service;

import com.phoenix.dto.CourseListItem;
import com.phoenix.dto.SelectedCourse;
import com.phoenix.dto.StudentGradeItem;
import com.phoenix.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Phoenix on 2016/12/21.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class StudentServiceTest {
    @Autowired
    private StudentService studentService;


    @Test
    public void queryStudentById() throws Exception {
        Student student = studentService.queryStudentById("2014121312");
        System.out.println(student);
    }

    @Test
    public void getAllCourses() throws Exception {
        List<CourseListItem> courseListItems = studentService.getAllCourses("2014123123");
        System.out.println(courseListItems);
    }

    @Test
    public void getSelectedCourse() throws Exception {
        List<SelectedCourse> selectedCourses = studentService.getSelectedCourse("2014123123");
        System.out.println(selectedCourses);
    }

    @Test
    public void excuteSelectCourse() throws Exception {
        int result = studentService.excuteSelectCourse("2014123123","CSE24306C","2014777123");
        System.out.println(result);
    }

    @Test
    public void excuteDeleteCourse() throws Exception {
        int result = studentService.excuteDeleteCourse("2014123123","CSE24306C","2014777123");
        System.out.println(result);
    }

    @Test
    public void getGradeList() throws Exception {
        List<StudentGradeItem> studentGradeItemList = studentService.getGradeList("2014123123");
        System.out.println(studentGradeItemList);
    }

}