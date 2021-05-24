package com.halo.mapper;

import com.halo.pojo.User;

import java.util.List;

/**
 * @author Halo
 * @date Created in 2020/11/07  11:15
 * @description
 */

public interface UserMapper {
    /**
     * 获取用户列表
     */
    List<User> getUserList();
}

