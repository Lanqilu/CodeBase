package com.halo.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.halo.pojo.User;
import com.halo.uitils.JsonUitils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Halo
 * @date Created in 2020/12/18  23:23
 * @description 使用Jackson将对象转换成JSON对象
 */

/**
 * 注解@RestController只会返回字符串,下面不需要使用@ResponseBody
 */
@Controller
public class UserController {
    /**
     * 使用toString方法直接返回字符串
     * <p>
     * 注解@ResponseBody不会走视图解析器直接返回一个字符串,配合@Controller使用
     */
    @RequestMapping("/json1")
    @ResponseBody
    public String json1() {
        // 创建对象
        User user = new User(1, "hello用户", 2);
        return user.toString();
    }

    /**
     * produces = "application/json;charset=utf-8" 原生解决中文乱码问题
     * 统一解决方法 详见spring.xml中配置
     */
    @RequestMapping(value = "/json2", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String json2() throws JsonProcessingException {
        // 创建jackson ObjectMapper对象
        ObjectMapper mapper = new ObjectMapper();
        // 创建对象
        User user = new User(1, "hello用户", 2);
        // 转换成JSON字符串
        String s = mapper.writeValueAsString(user);
        return s;
    }

    /**
     * 返回ArrayList对象
     */
    @RequestMapping("/json3")
    @ResponseBody
    public String json3() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        ArrayList<User> userList = new ArrayList<>();
        User user1 = new User(1, "hello用户1", 1);
        User user2 = new User(2, "hello用户2", 2);
        User user3 = new User(3, "hello用户3", 3);
        User user4 = new User(4, "hello用户4", 4);
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);

        return mapper.writeValueAsString(userList);
    }

    /**
     * 传统解决返回日期问题
     */
    @RequestMapping("/json4")
    @ResponseBody
    public String json4() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return mapper.writeValueAsString(simpleDateFormat.format(date));
    }

    /**
     * 使用ObjectMapper解决返回日期问题
     */
    @RequestMapping("/json5")
    @ResponseBody
    public String json5() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        // 使用ObjectMapper格式化日期输出
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        // 自定义日期格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        mapper.setDateFormat(simpleDateFormat);

        Date date = new Date();

        return mapper.writeValueAsString(date);
    }

    /**
     * 使用自己封装的类解决返回日期问题
     */
    @RequestMapping("/json6")
    @ResponseBody
    public String json6() {
        Date date = new Date();
        return JsonUitils.getJson(date, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 使用Fastjson
     */
    @RequestMapping("/json7")
    @ResponseBody
    public String json7() {
        ArrayList<User> userList = new ArrayList<>();
        User user1 = new User(1, "hello用户0", 1);
        User user2 = new User(2, "hello用户1", 2);
        User user3 = new User(3, "hello用户2", 3);
        User user4 = new User(4, "hello用户3", 4);
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);

        return JSON.toJSONString(userList);


    }

}
