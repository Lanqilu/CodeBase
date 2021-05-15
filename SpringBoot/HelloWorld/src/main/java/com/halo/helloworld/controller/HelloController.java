package com.halo.helloworld.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Halo
 * @date Created in 2021/05/15 10:53 PM
 * @description
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String index(){
        return "Hello,SpringBoot!";
    }
}
