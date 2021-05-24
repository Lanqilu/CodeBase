package com.halo.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Halo
 * @date Created in 2020/12/16  21:04
 * @description 3.编写Controller
 */
public class HelloController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        // 业务代码
        String result = "HelloSpringMVC";
        modelAndView.addObject("msg", result);

        // 视图跳转
        modelAndView.setViewName("hello");

        return modelAndView;
    }
}
// TODO:Tomcat打包有问题
