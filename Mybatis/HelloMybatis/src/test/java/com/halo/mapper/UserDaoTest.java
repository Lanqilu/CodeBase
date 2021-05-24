package com.halo.mapper;

import com.halo.pojo.User;
import com.halo.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;


import java.util.List;

/**
 * @author Halo
 * @date Created in 2020/11/07  11:26
 * @description
 */
public class UserDaoTest {
    @Test
    /**
     * 使用 getMapper
     */
    public void testUserDao() {
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
     * 使用 sqlSession.selectList，不建议使用
     */
    public void testUserDao2() {
        // 获得 sqlSession 对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        // 获取
        List<User> userList = sqlSession.selectList("com.halo.mapper.UserMapper.getUserList");
        // 遍历并输出
        for (User user : userList) {
            System.out.println(user);
        }
        // 关闭 sqlSession
        sqlSession.close();
    }
}
