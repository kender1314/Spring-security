package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author jiang.he
 * @Version 1.0.0 RELEASE
 * @Date 2021/1/13 19:37
 */
@Controller
@RequestMapping("/demo")
public class DemoController {

    @ResponseBody
    @GetMapping("hello")
    public String hello(){
        return "Hello Spring Security!";
    }
}
