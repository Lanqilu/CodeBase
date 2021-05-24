package com.halo.mapper;

import com.halo.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * @author Halo
 * @date Created in 2020/11/07  11:15
 * @description
 */

public interface UserMapper {

    /**
     * 模糊查询
     *
     * @param value 查询值
     * @return null
     */
    List<User> getUserLike(String value);

    /**
     * 分页查询
     *
     * @param map 查询参数
     * @return null
     */
    List<User> getUserByLimit(Map<String, Integer> map);

    /**
     * 获取用户列表
     *
     * @return UserList
     */
    List<User> getUserList();

    /**
     * 根据ID查询用户
     *
     * @param id 用户ID
     * @return 对应ID用户
     */
    User getUserByID(int id);


    /**
     * 插入用户
     *
     * @param user User对象
     * @return null
     */
    int addUser(User user);


    /**
     * 万能的Map
     *
     * @param
     * @return
     */
    int getUser(Map<String, Object> map);

    /**
     * 修改用户
     *
     * @param user 用户对象
     * @return null
     */
    int updateUser(User user);

    /**
     * 删除用户
     *
     * @param id 需要删除用户的ID
     * @return null
     */
    int deleteUser(int id);

    void getUserByLimit();
}

