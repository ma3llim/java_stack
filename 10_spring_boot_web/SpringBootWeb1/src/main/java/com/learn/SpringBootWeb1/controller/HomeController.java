package com.learn.SpringBootWeb1.controller;

import com.learn.SpringBootWeb1.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @ModelAttribute("course")
    public String courseName(){
        return "Java";
    }

    @RequestMapping("/")
    public String home(){
        return "index";
    }

    @RequestMapping("add")
    public ModelAndView add(@RequestParam("num1") int number1, @RequestParam("num2") int number2, ModelAndView modelView){
        int result = number1+number2;

        modelView.addObject("result", result);
        modelView.setViewName("result");
        return modelView;
    }

    @RequestMapping("addEmployee")
    public String addEmployee(@ModelAttribute("result") Employee emp){
        return "result";
    }
}
