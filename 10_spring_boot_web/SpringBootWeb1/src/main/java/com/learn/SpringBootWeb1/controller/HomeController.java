package com.learn.SpringBootWeb1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(){
        return "index";
    }

    @RequestMapping("add")
    public ModelAndView add(@RequestParam("num1") int number1, @RequestParam("num2") int number2, ModelAndView modelView){
        int result = number1+number2;0

        modelView.addObject("result", result);
        modelView.setViewName("result");
        return modelView;
    }
}
