package com.phoenix.dao;

import com.phoenix.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Phoenix on 2016/12/13.
 */
public interface StudentDao {

    /**
     * 通过学生ID查询学生
     * @param stuId
     * @return
     */
    Student queryById(String stuId);

    /**
     * 插入新学生
     * @param student
     * @return
     */
    int insertStudent(@Param("student") Student student);

    /**
     * 通过ID删除学生
     * @param stuId
     * @return
     */
    int deleteStudentById(String stuId);

    /**
     * 更改学生选课权限
     * @param stuId
     * @param stuAuthority
     * @return
     */
    int updateStudentAuthority(@Param("stuId") String stuId, @Param("stuAuthority") int stuAuthority);

    /**
     * 查询全部学生
     * @return
     */
    List<Student> queryAllStudent();

    /**
     * 选课开关
     * @param stuAuthority
     * @return
     */
    int updateAllAuthority(@Param("stuAuthority") int stuAuthority);

}
