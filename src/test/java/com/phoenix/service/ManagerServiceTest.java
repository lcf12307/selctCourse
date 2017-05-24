package com.phoenix.service;

import com.phoenix.entity.Course;
import com.phoenix.entity.Student;
import com.phoenix.entity.Teacher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by Phoenix on 2016/12/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class ManagerServiceTest {

    @Autowired
    private ManagerService managerService;

    @Test
    public void insertTeacher() throws Exception {
        Teacher teacher = new Teacher("2014888888","卧槽","男","教授","0000000001");
        int result = managerService.insertTeacher(teacher);
        System.out.println(result);
    }

    @Test
    public void deleteTeacher() throws Exception {
        int result = managerService.deleteTeacher("2014888888");
        System.out.println(result);
    }

    @Test
    public void insertStudent() throws Exception {
        Student student = new Student("2014333333", "擦擦", "男", "04");
        int result = managerService.insertStudent(student);
        System.out.println(result);
    }

    @Test
    public void deleteStudent() throws Exception {
        int result = managerService.deleteStudent("2014333333");
        System.out.println(result);
    }

    @Test
    public void insertCourse() throws Exception {
        Course course = new Course("EEE66666A","DOTA进阶",2,2.5);
        int result = managerService.insertCourse(course);
        System.out.println(course);
    }

    @Test
    public void deleteCourse() throws Exception {
        int result = managerService.deleteCourse("EEE66666A");
        System.out.println(result);
    }

}