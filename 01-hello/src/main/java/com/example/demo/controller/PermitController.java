package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author jiang.he
 * @Version 1.0.0 RELEASE
 * @Date 2021/3/10 21:58
 */
@Controller
@RequestMapping("/permit")
public class PermitController {

    @ResponseBody
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String permitHello(){
        return "permit hello!";
    }

    @ResponseBody
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String permitTest(){
        return "permit test!";
    }
}
