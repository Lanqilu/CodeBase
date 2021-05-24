package com.halo.controller;


import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Halo
 * @date Created in 2020/11/22  21:48
 * @description
 */
public class HelloController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // ModelAndView 模型和视图
        ModelAndView mv = new ModelAndView();

        // 封装对象
        mv.addObject("msg", "HelloSpringMVC");
        // 封装需要跳转的视图
        mv.setViewName("hello");
        return mv;
    }
}
