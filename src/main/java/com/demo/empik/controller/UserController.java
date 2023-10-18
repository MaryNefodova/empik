package com.demo.empik.controller;

import com.demo.empik.model.User;
import com.demo.empik.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    UserService service;

    @GetMapping(value = "user/{name}")
    public User getTestData(@PathVariable String name) {

        return service.getUserData(name);
    }
}
