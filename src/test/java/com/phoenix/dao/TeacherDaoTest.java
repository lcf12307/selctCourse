package com.phoenix.dao;

import com.phoenix.entity.Teacher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Phoenix on 2016/12/21.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class TeacherDaoTest {
    @Autowired
    private TeacherDao teacherDao;

    @Test
    public void queryTeacherById() throws Exception {
        Teacher teacher = teacherDao.queryTeacherById("2014777129");
        System.out.println(teacher);
    }

    @Test
    public void insertTeacher() throws Exception {
        teacherDao.insertTeacher(new Teacher("2014777777", "xx", "男","教授",
                                            "0000000001", "123456"));
    }

    @Test
    public void updateTeacherAuthority() throws Exception {
        teacherDao.updateTeacherAuthority("2014777123", 1);
    }

    @Test
    public void deleteTeacherById() throws Exception {
        teacherDao.deleteTeacherById("2014777777");
    }

}