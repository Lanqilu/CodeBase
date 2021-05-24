package com.halo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Halo
 * @date Created in 2020/12/16  23:35
 * @description 注解实现Controller
 */

@Controller
public class ControllerDemo2 {
    @RequestMapping("test2")
    public String test1(Model model) {
        model.addAttribute("msg", "Controller2");
        return "controller";
    }
}
