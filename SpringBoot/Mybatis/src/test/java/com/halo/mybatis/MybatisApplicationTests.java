package com.halo.mybatis;

import com.halo.mybatis.entity.User;
import com.halo.mybatis.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class MybatisApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private UserMapper userMapper;

    @Test
    public void selectAllUser() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectAllUser();
        userList.forEach(System.out::println);
    }

}
