package com.halo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Halo
 * @date Created in 2020/12/18  21:22
 * @description 不使用视图解析器(注释视图解析器)进行转发和重定向
 */
@Controller
public class ModelTest2 {
    @RequestMapping("m2/t1")
    public String test1(Model model) {
        // 实现转发,不建议使用
        model.addAttribute("msg", "m2/t1");
        // return "/WEB-INF/jsp/controller.jsp";
        return "forward:/WEB-INF/jsp/controller.jsp";
    }

    @RequestMapping("m2/t2")
    public String test2(Model model) {
        model.addAttribute("msg", "m2/t2");
        // 有视图解析器同样可以根据这个方法重定向
        return "redirect:/index.jsp";
    }
}
