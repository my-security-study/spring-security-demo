package com.example.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenling
 * @date 2020/2/17 12:09
 * @since V1.0.0
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public String  test(){
        return "security   hello    world     !";
    }

}
