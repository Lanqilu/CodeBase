package com.halo.freemarker.controller;

import cn.hutool.core.util.ObjectUtil;
import com.halo.freemarker.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Halo
 * @date Created in 2021/05/23 6:56 PM
 * @description
 */
@Controller
@Slf4j
public class IndexController {

    @GetMapping(value = {"", "/"})
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();

        Person person = (Person) request.getSession().getAttribute("person");
        if (ObjectUtil.isNull(person)) {
            mv.setViewName("redirect:/user/login");
        } else {
            mv.setViewName("page/index");
            mv.addObject(person);
        }

        return mv;
    }
}
