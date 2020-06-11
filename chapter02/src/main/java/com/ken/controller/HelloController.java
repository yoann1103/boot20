package com.ken.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    /**
     * 访问
     * https://127.0.0.1:8088/chapter02/hello
     * @return
     */
    @GetMapping("/hello")
    public String hello() {
        return "hello spring boot!";
    }
}
