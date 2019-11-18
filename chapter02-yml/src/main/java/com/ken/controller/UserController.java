package com.ken.controller;

import com.ken.properties.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private Users users;

    @GetMapping("/user")
    public String user() {
        return users.toString();
    }
}
