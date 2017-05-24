package com.phoenix.dao;

import com.phoenix.entity.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Phoenix on 2016/12/13.
 */
public interface TeacherDao {

    /**
     * 通过ID查询老师
     * @param teacherId
     * @return
     */
    Teacher queryTeacherById(String teacherId);

    /**
     * 插入新教师
     * @param teacher
     * @return
     */
    int insertTeacher(@Param("teacher") Teacher teacher);

    /**
     * 通过教师ID修改权限
     * @param teacherId
     * @return
     */
    int updateTeacherAuthority(@Param("teacherId") String teacherId, @Param("teacherAuthority") int teacherAuthority);

    /**
     * 通过教师ID移除教师
     * @param teacherId
     * @return
     */
    int deleteTeacherById(String teacherId);

    /**
     * 查询全部教师
     * @return
     */
    List<Teacher> queryAllTeacher();
}
