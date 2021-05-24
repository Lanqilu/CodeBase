package com.halo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author Halo
 * @date Created in 2020/12/17  00:09
 * @description
 */
@Controller
public class RestFulController {

    @RequestMapping("/add")
    public String test1(int a, int b, Model model) {
        // http://localhost:8080/Controller_Web_exploded/add?a=1&b=2
        int res = a + b;
        model.addAttribute("msg", "结果为" + res);
        return "controller";
    }

    @RequestMapping("/add2/{a}/{b}")
    public String test2(@PathVariable int a, @PathVariable int b, Model model) {
        int res = a + b;
        model.addAttribute("msg", "RestFul结果为" + res);
        return "controller";
    }

    @RequestMapping(value = "/add3/{a}/{b}", method = RequestMethod.GET)
    public String test3(@PathVariable int a, @PathVariable int b, Model model) {
        // http://localhost:8080/Controller_Web_exploded/add?a=1&b=2
        int res = a + b;
        model.addAttribute("msg", "Get结果为" + res);
        return "controller";
    }

    @RequestMapping(value = "/add3/{a}/{b}", method = RequestMethod.POST)
    public String test4(@PathVariable int a, @PathVariable int b, Model model) {
        int res = a + b;
        model.addAttribute("msg", "Post结果为" + res);
        return "controller";
    }
}
