package com.halo.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Halo
 * @date Created in 2020/12/16  23:28
 * @description 实现Controller接口类, 即控制器
 *
 * 实现接口方法较老,不建议使用
 * 缺点:一个控制器只有一个方法
 */
public class ControllerDemo1 implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "ControllerDemo1");
        mv.setViewName("controller");

        return mv;
    }
}
