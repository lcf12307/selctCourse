package com.phoenix.service;

import com.phoenix.dto.Teacher.AllCourseStudentListItem;
import com.phoenix.entity.Teacher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Phoenix on 2016/12/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class TeacherServiceTest {
    @Autowired
    private TeacherService teacherService;

    @Test
    public void queryTeacherById() throws Exception {
        Teacher teacher = teacherService.queryTeacherById("2014777129");
        System.out.println(teacher);
    }

    @Test
    public void updateCourseGrade() throws Exception {
        teacherService.updateCourseGrade("2014123123", "CSE31300C", "2014777124",96);
    }

    @Test
    public void getTeachCourseStudentList() throws Exception {
        List<AllCourseStudentListItem> allCourseStudentListItemList = teacherService.getTeachCourseStudentList("2014777129");
        System.out.println(allCourseStudentListItemList);
    }

}