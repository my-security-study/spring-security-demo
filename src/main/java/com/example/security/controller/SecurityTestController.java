package com.example.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author chenling
 * @date 2020/2/10 13:51
 * @since V1.0.0
 */
@Controller
public class SecurityTestController {


    @GetMapping("/test")
    public String securityTest(){
        return "Spring Security hello world";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

}
