package com.bright.assignment_backend.service.impl;

import com.bright.assignment_backend.entity.User;
import com.bright.assignment_backend.repository.UserRepository;
import com.bright.assignment_backend.service.UserService;
import com.bright.assignment_backend.service.spec.UserSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserImpl implements UserService {
    @Autowired
    private UserRepository repo ;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @Override
    public UserSpec.RegisterRes register(UserSpec.RegisterReq req) {
        User user = new User();
        user.setEmail(req.getEmail());
        user.setName(req.getName());
        user.setPassword(encoder.encode(req.getPassword()));
        repo.save(user);
        UserSpec.RegisterRes res = new UserSpec.RegisterRes();
        res.setMessage("User registered successfully");
        return res;
    }
}
