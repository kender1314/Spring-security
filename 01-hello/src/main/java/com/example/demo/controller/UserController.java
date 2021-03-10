package com.example.demo.controller;

import com.example.demo.service.impl.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author jiang.he
 * @Version 1.0.0 RELEASE
 * @Date 2021/3/10 22:01
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private MyUserDetailsService userDetailsService;

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String userLogin(){
        return "User login!";
    }

}
