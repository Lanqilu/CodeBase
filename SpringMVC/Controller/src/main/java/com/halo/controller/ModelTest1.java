package com.halo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Halo
 * @date Created in 2020/12/18  21:13
 * @description
 */

@Controller
public class ModelTest1 {
    @RequestMapping("/m1/t1")
    public String test(HttpServletRequest request, HttpServletResponse response) {
        // 获取SessionID
        HttpSession session = request.getSession();
        System.out.println(session.getId());
        return "controller";
    }
}
