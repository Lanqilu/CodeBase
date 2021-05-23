package com.halo.freemarker.controller;

import com.halo.freemarker.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Halo
 * @date Created in 2021/05/23 6:57 PM
 * @description
 */
@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {
    @PostMapping("/login")
    public ModelAndView login(Person person, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();

        mv.addObject(person);
        mv.setViewName("redirect:/");

        request.getSession().setAttribute("person", person);
        return mv;
    }

    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("page/login");
    }
}