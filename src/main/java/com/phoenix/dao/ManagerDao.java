package com.phoenix.dao;

import com.phoenix.entity.Manager;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Phoenix on 2016/12/13.
 */
public interface ManagerDao {

    /**
     * 通过管理员id查询
     * @param managerId
     * @return
     */
    Manager queryManagerById(String managerId);

    /**
     * 通过管理员id删除管理员
     * @param managerId
     * @return
     */
    int deleteManagerById(String managerId);

    /**
     * 添加管理员
     * @param manager
     * @return
     */
    int insertManager(@Param("manager") Manager manager);
}
