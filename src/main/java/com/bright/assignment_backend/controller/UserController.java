package com.bright.assignment_backend.controller;

import com.bright.assignment_backend.configuration.UserDetailsImpl;
import com.bright.assignment_backend.entity.User;
import com.bright.assignment_backend.service.UserService;
import com.bright.assignment_backend.spec.UserSpec;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody UserSpec.RegisterReq req){
        UserSpec.RegisterRes res = service.register(req);
        if(!res.getSuccess()){
            return ResponseEntity.badRequest().body(res);
        }
        return ResponseEntity.ok().body(res);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody UserSpec.LoginReq req){
        UserSpec.LoginRes res = service.login(req);
        if(!res.getSuccess()){
            return ResponseEntity.status(401).body(res);
        }
        return ResponseEntity.ok().body(res);
    }

    @GetMapping("/getUserProfile")
    public ResponseEntity<?> getUserProfile(){
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDetails.getUser();
        return ResponseEntity.ok().body(new UserSpec.GetProfileRes().setId(user.getId()).setName(user.getName()).setEmail(user.getEmail()));
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(){
        SecurityContextHolder.clearContext();
        return ResponseEntity.ok().body(new UserSpec.LogOutRes());
    }

}
