package com.bright.assignment_backend.controller;

import com.bright.assignment_backend.service.UserService;
import com.bright.assignment_backend.service.spec.UserSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping("/register")
    public UserSpec.RegisterRes register(@RequestBody UserSpec.RegisterReq req){
        return service.register(req);
    }


}
