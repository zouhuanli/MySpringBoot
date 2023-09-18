package com.homura.myspringboot.controller;

import com.homura.myspringboot.entity.User;
import com.homura.myspringboot.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @RequestMapping("/add")
    public User add(User user) {
        LOGGER.info("add method:{}", user);
        userService.add(user);
        return user;
    }

    @GetMapping("/listAll")
    public List<User> listAll() {
        LOGGER.info("listAll method");
        return userService.listAll();
    }
}
