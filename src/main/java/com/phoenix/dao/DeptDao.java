package com.phoenix.dao;

import com.phoenix.entity.Dept;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Phoenix on 2016/12/13.
 */
public interface DeptDao {

    /**
     * 通过id查询系
     * @param deptId
     * @return
     */
    Dept queryDeptById(String deptId);

    /**
     * 通过id删除系
     * @param deptId
     * @return
     */
    int deleteDeptById(String deptId);

    /**
     * 添加系
     * @param dept
     * @return
     */
    int insertDept(@Param("dept") Dept dept);

    /**
     * 获取全部系信息
     * @return
     */
    List<Dept> getAllDept();
}
