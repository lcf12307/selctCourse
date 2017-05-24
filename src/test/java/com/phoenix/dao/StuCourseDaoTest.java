package com.phoenix.dao;

import com.phoenix.entity.StuCourse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Phoenix on 2016/12/21.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class StuCourseDaoTest {

    @Autowired
    private StuCourseDao stuCourseDao;

    @Test
    public void querySelectedCoursesByStudentId() throws Exception {
        List<StuCourse> stuCourseList = stuCourseDao.querySelectedCoursesByStudentId("2014123123");
        System.out.println(stuCourseList);
    }


}