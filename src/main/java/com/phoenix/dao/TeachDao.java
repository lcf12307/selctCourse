package com.phoenix.dao;

import com.phoenix.entity.Teach;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Phoenix on 2016/12/20.
 */
public interface TeachDao {

    /**
     * 通过教师id查询开课信息
     * @param teacherId
     * @return
     */
    List<Teach> queryTeachByTeacherId(String teacherId);

    /**
     * 增加开课信息
     * @param teacherId
     * @param courseId
     * @return
     */
    int insertTeachCourse(@Param("teacherId") String teacherId, @Param("courseId") String courseId);


    /**
     * 删除开课信息
     * @param teacherId
     * @param courseId
     * @return
     */
    int deleteTeachCourse(@Param("teacherId") String teacherId, @Param("courseId") String courseId);

    /**
     * 获取全部授课信息
     * @return
     */
    List<Teach> queryAllTeachInfo();

    int deleteByCourseId(@Param("courseId") String courseId);

    int deleteByTeacherId(@Param("teacherId") String teacherId);
}
