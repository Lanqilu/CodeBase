package com.halo.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Halo
 * @date Created in 2020/11/07  11:00
 * @description 工具栏
 */
public class MyBatisUtils {
    /**
     * 提升作用域
     */
    private static SqlSessionFactory sqlSessionFactory;

    static {
        // 获取sqlSessionFactory对象
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取SqlSession实例,在此之前需要提升作用域
     */
    public static SqlSession getSqlSession() {
        // true 表示自动提交事务
        return sqlSessionFactory.openSession(true);
    }
}
