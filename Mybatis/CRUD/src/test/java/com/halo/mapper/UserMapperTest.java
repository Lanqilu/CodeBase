package com.halo.mapper;

import com.halo.pojo.User;
import com.halo.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;


import java.util.HashMap;
import java.util.List;

/**
 * @author Halo
 * @date Created in 2020/11/07  11:26
 * @description
 */
public class UserMapperTest {

    @Test
    /**
     * 分页查询
     */

    public void testGetUserByLimit() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        HashMap<String, Integer> map = new HashMap<>();
        map.put("startIndex", 1);
        map.put("pageSize", 2);


        List<User> userList = mapper.getUserByLimit(map);
        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();
    }


    @Test
    /**
     * 模糊查询
     */
    public void testLike() {
        // 获得 sqlSession 对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        // 执行 SQL  使用 getMapper 方法
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> like = mapper.getUserLike("%李%");

        for (User user : like) {
            System.out.println(user);
        }


        // 关闭 sqlSession
        sqlSession.close();
    }


    @Test
    /**
     * 使用 getMapper
     */
    public void testUserMapper() {
        // 获得 sqlSession 对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        // 执行 SQL  使用 getMapper 方法
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 执行方法
        List<User> userList = mapper.getUserList();
        // 遍历并输出
        for (User user : userList) {
            System.out.println(user);
        }
        // 关闭 sqlSession
        sqlSession.close();
    }


    @Test
    /**
     * 测试getUserByID方法
     */
    public void testGetUserByID() {
        // 获得 sqlSession 对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user2 = mapper.getUserByID(2);
        System.out.println("user2 = " + user2);

        // 关闭 sqlSession
        sqlSession.close();
    }

    @Test
    /**
     * 测试addUser方法
     * 增删改需要提交调事务
     */
    public void testAddUser() {
        // 获得 sqlSession 对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int halo = mapper.addUser(new User(5, "李五", "123456"));
        if (halo > 0) {
            System.out.println("插入成功");
        }

        // 提交事务
        sqlSession.commit();

        // 关闭 sqlSession
        sqlSession.close();
    }

    @Test
    /**
     * 测试updateUser方法
     * 增删改需要提交调事务
     */
    public void testUpdateUser() {
        // 获得 sqlSession 对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.updateUser(new User(4, "whl", "789789"));

        // 提交事务
        sqlSession.commit();

        // 关闭 sqlSession
        sqlSession.close();
    }

    @Test
    /**
     * 测试deleteUser方法
     * 增删改需要提交调事务
     */
    public void testDeleteUser() {
        // 获得 sqlSession 对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.deleteUser(4);

        // 提交事务
        sqlSession.commit();

        // 关闭 sqlSession
        sqlSession.close();
    }
}
