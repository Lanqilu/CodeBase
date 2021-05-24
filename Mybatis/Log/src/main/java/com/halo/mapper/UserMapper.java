package com.halo.mapper;

import com.halo.pojo.User;

/**
 * @author Halo
 * @date Created in 2020/11/07  11:15
 * @description
 */

public interface UserMapper {


    /**
     * 根据ID查询用户
     *
     * @param id 用户ID
     * @return 对应ID用户
     */
    User getUserByID(int id);


}

