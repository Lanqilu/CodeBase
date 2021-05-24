package com.halo.controller;

import com.halo.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @author Halo
 * @date Created in 2020/12/18  21:44
 * @description 用于测试前端传递参数
 */
@Controller
@RequestMapping("/user")
public class UserController {
    /**
     * 传参必须要指定名称
     *
     * @param name
     * @param model
     * @return 返回URL的参数到视图
     */
    @GetMapping("/t1")
    public String test1(String name, Model model) {
        // 接受前端参数
        // localhost:8080/user/t1?name=xxx
        System.out.println("接受到前端的参数为:" + name);
        // 返回结果给前端
        model.addAttribute("msg", name);
        // 跳转视图
        return "controller";
    }

    /**
     * 加入@RequestParam("username") 必须使用username名传参
     *
     * @param name
     * @param model
     * @return 返回URL的参数到视图
     */
    @GetMapping("/t2")
    public String test2(@RequestParam("username") String name, Model model) {
        // 接受前端参数
        // localhost:8080/user/t1?name=xxx
        System.out.println("接受到前端的参数为:" + name);
        // 返回结果给前端
        model.addAttribute("msg", name);
        // 跳转视图
        return "controller";
    }

    /**
     * 前端提交一个User对象
     * localhost:8080/user/t3?id=1&name=hello&age=1
     * 参数名要对应,参数前后顺序无关,没有对应参数则为默认值
     */
    @GetMapping("/t3")
    public String test3(User user, Model model) {
        System.out.println("接受到前端的参数为:" + user);
        model.addAttribute("msg", user);
        return "controller";
    }

    /**
     * 使用ModelMap返回结果给前端
     * localhost:8080/user/t3?id=1&name=hello&age=1
     * Model精简ModelMap
     * ModelMap继承了LinkedHashMap拥有LinkedHashMap的特性和方法
     * ModeAndView在储存数据的同时可以设置返回的逻辑视图,实现控制展示层的跳转
     */
    @GetMapping("/t4")
    public String test4(User user, ModelMap modelMap) {
        System.out.println("接受到前端的参数为:" + user);
        modelMap.addAttribute("msg", user);
        return "controller";
    }
}
