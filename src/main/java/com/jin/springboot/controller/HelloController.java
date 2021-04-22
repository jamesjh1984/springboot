package com.jin.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String index() {
        System.out.println("HelloController.index()...");
        return "hello";
    }
}