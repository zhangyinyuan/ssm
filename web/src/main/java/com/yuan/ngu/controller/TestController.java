package com.yuan.ngu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * 加深对Spring MVC 的理解
 */
@Controller
public class TestController {

    @RequestMapping(path = "/test", method = RequestMethod.GET)
    public ModelAndView index(ModelAndView mv) {
        mv.setViewName("test");
        mv.addObject("result", "Welcome baby !");
        return mv;
    }
}
