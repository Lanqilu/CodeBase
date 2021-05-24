package com.halo.authority.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("hello")
    public String hello() {
        return "Hello Halo";
    }

    @GetMapping("index")
    public String index() {
        return "Index <a href='/logout'>退出</a>";
    }

}
