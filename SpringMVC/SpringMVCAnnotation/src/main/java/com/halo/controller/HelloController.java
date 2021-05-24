package com.halo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Halo
 * @date Created in 2020/12/16  22:17
 * @description
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/h1")
    public String hello(Model model) {
        // 封装数据
        model.addAttribute("msg", "HelloSpringMVC");
        // 会被视图解析其处理
        return "hello";
    }
}
