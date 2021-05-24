package com.halo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Halo
 * @date Created in 2020/12/18  22:23
 * @description 乱码问题测试类
 */
@Controller
@RequestMapping("encode")
public class EncodingTest {
    @PostMapping("t1")
    public String test1(String name, Model model) {
        // 此时已经输出乱码,是Java层面的问题，不是前端格式的问题
        System.out.println(name);
        model.addAttribute("msg", name);
        return "controller";
    }

    // 通过过滤器解决乱码 见filter包

    // 使用SpringMVC的乱码过滤器 见web.xml


}
