package com.jin.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexController {

//    @RequestMapping("index")
//    public String index() {
//        return "index";
//    }



    @RequestMapping("index")
    public String index(Model model) {
        model.addAttribute("msg","Hello, SpringBoot, this is Thymeleaf generated.");
        return "index";
    }




}
