package com.phoenix.dao;

import com.phoenix.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by Phoenix on 2016/12/21.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class StudentDaoTest {

    @Autowired
    private StudentDao studentDao;

    @Test
    public void queryById() throws Exception {
        String id = "2014121312";
        Student student = studentDao.queryById(id);
        System.out.println(student);
    }

    @Test
    public void insertStudent() throws Exception {
        String id = "2014121666";
        Student newStudent = new Student(id, "蛤蛤", "男", "01", "123456");
        studentDao.insertStudent(newStudent);
    }

    @Test
    public void deleteStudentById() throws Exception {
        studentDao.deleteStudentById("2014121666");
    }

    @Test
    public void updateStudentAuthority() throws Exception {
        studentDao.updateStudentAuthority("2014121312",1);
    }

}