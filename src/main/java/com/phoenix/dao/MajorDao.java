package com.phoenix.dao;

import com.phoenix.entity.Major;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Phoenix on 2016/12/13.
 */
public interface MajorDao {

    /**
     * 通过id查询专业
     * @param majorId
     * @return
     */
    Major queryMajorById(String majorId);

    /**
     * 插入专业
     * @param major
     * @return
     */
    int insertMajor(@Param("major") Major major);

    /**
     * 通过id删除专业
     * @param majorId
     * @return
     */
    int deleteMajorById(String majorId);

    /**
     * 获取全部专业信息
     * @return
     */
    List<Major> getAllMajor();
}
