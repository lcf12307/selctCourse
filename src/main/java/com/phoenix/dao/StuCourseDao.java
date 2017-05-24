package com.phoenix.dao;

import com.phoenix.entity.StuCourse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Phoenix on 2016/12/13.
 */
public interface StuCourseDao {

    /**
     * 通过学生id获取选课信息
     * @param studentId
     * @return
     */
    List<StuCourse> querySelectedCoursesByStudentId(String studentId);

    /**
     * 通过教师id获取选课信息
     * @param teacherId
     * @return
     */
    List<StuCourse> querySelectedCoursesByTeacherId(@Param("teacherId") String teacherId, @Param("courseId") String courseId);

    /**
     * 插入选课信息
     * @param stuId
     * @param courseId
     * @param teacherId
     * @return
     */
    int insertSelectedCourse(@Param("stuId") String stuId, @Param("courseId") String courseId, @Param("teacherId") String teacherId);

    /**
     * 通过学生删除选课信息
     * @param stuId
     * @param courseId
     * @param teacherId
     * @return
     */
    int deleteSelectedCourseByStudent(@Param("stuId") String stuId, @Param("courseId") String courseId, @Param("teacherId") String teacherId);

    /**
     * 通过教师删除选课信息
     * @param courseId
     * @param teacherId
     * @return
     */
    int deleteSelectedCourseByTeacher(@Param("courseId") String courseId,@Param("teacherId") String teacherId);

    /**
     * 通过课程ID删除所有相关课程
     * @param courseId
     * @return
     */
    int deleteByCourseId(@Param("courseId") String courseId);

    /**
     * 通过教师Id删除相关所有课程
     * @param teacherId
     * @return
     */
    int deleteByTeacherId(@Param("teacherId") String teacherId);

    /**
     * 通过学生Id删除所有课程
     * @param stuId
     * @return
     */
    int deleteByStudentId(@Param("stuId") String stuId);

    /**
     * 更改学生成绩
     * @param stuId
     * @param courseId
     * @param teacherId
     * @param grade
     * @return
     */
    int updateStudentGrade(@Param("stuId") String stuId, @Param("courseId") String courseId, @Param("teacherId") String teacherId, @Param("grade") double grade);
}
