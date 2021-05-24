package com.halo.mapper;

import com.halo.pojo.User;
import org.apache.ibatis.annotations.*;

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
     * 万能的Map
     *
     * @param
     * @return
     */
    int getUser(Map<String, Object> map);

    /**
     * 获取用户列表
     *
     * @return UserList
     */
    @Select("select * from user")
    List<User> getUserList();

    /**
     * 根据ID查询用户
     *
     * @param id 用户ID
     * @return 对应ID用户
     */
    @Select("select * from user where id = #{id}")
    User getUserByID(@Param("id") int id);

    /**
     * 插入用户
     *
     * @param user User对象
     * @return null
     */
    @Insert("insert into user(id,name,pwd) values (#{id},#{name},#{pwd});")
    int addUser(User user);

    /**
     * 修改用户
     *
     * @param user 用户对象
     * @return null
     */
    @Update("update user set name=#{name},pwd=#{pwd} where id=#{id};")
    int updateUser(User user);

    /**
     * 删除用户
     *
     * @param id 需要删除用户的ID
     * @return null
     */
    @Delete("delete from user where id = #{id};")
    int deleteUser(@Param("id") int id);

}

