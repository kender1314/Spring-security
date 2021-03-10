package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author jiang.he
 * @Version 1.0.0 RELEASE
 * @Date 2021/3/10 22:45
 */
@Controller
@RequestMapping("/")
public class IndexController {
    @ResponseBody
    @GetMapping("/")
    public String hello(){
        return "This is index page!";
    }
}
