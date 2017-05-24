package com.phoenix.dao;

import com.phoenix.entity.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Phoenix on 2016/12/13.
 */
public interface CourseDao {

    /**
     * 通过课程ID查询课程
     * @param courseId
     * @return
     */
    Course queryCourseById(String courseId);

    /**
     * 插入课程
     * @param course
     * @return
     */
    int insertCourse(@Param("course") Course course);

    /**
     * 通过ID删除课程
     * @param courseId
     * @return
     */
    int deleteCourseById(String courseId);

    /**
     * 查询全部课程
     * @return
     */
    List<Course> queryAllCourses();
}
