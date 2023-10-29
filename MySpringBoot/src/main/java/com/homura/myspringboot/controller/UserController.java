package com.homura.myspringboot.controller;

import com.homura.myspringboot.entity.base.ResponseResult;
import com.homura.myspringboot.entity.dvo.User;
import com.homura.myspringboot.service.UserService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    public ResponseResult<User> add(@Valid @RequestBody User user, BindingResult bindingResult) {
        LOGGER.info("add method:{}", user);
        if (bindingResult.hasErrors()) {
            List<ObjectError> errors = bindingResult.getAllErrors();
            errors.forEach(p -> {
                FieldError fieldError = (FieldError) p;
                LOGGER.error("Invalid Parameter : object - {},field - {},errorMessage - {}", fieldError.getObjectName(), fieldError.getField(), fieldError.getDefaultMessage());
            });
            return ResponseResult.fail("invalid parameter");
        }
        userService.add(user);
        return ResponseResult.success(user);
    }

    @GetMapping("/listAll")
    public List<User> listAll() {
        LOGGER.info("listAll method");
        return userService.listAll();
    }


    @GetMapping("/get/{uid}")
    public User getByUid(@PathVariable("uid") Integer uid) {
        LOGGER.info("listAll method");
        return userService.getByUid(uid);
    }
}