package com.halo.controller;


import com.halo.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Halo
 * @date Created in 2020/12/19  22:36
 * @description
 */
@RestController
public class AjaxController {
    @RequestMapping("/t1")
    public String test1() {
        return "hello";
    }

    @RequestMapping("/t2")
    public void test2(String name, HttpServletResponse response) throws IOException {
        System.out.println("a1:param=>" + name);
        String key = "hello";
        if (key.equals(name)) {
            response.getWriter().println("true");
        }
        else {
            response.getWriter().println("false");
        }
    }

    @RequestMapping("/t3")
    public List<User> test3() {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User(1, "hello,世界1", "未知"));
        users.add(new User(2, "hello,世界2", "男"));
        users.add(new User(3, "hello,世界3", "女"));
        return users;
    }

    @RequestMapping("/t4")
    public String test4(String name, String pwd) {
        String msg = "";
        String userName = "admin";
        String password = "123456";
        if (name != null) {
            if (userName.equals(name)) {
                msg = "ok";
            }
            else {
                msg = "用户名有误";
            }
        }
        if (pwd != null) {
            if (password.equals(pwd)) {
                msg = "ok";
            }
            else {
                msg = "密码有误";
            }
        }
        return msg;
    }
}
