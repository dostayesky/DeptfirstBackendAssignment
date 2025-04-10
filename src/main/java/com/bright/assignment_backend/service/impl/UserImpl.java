package com.bright.assignment_backend.service.impl;

import com.bright.assignment_backend.entity.User;
import com.bright.assignment_backend.repository.UserRepository;
import com.bright.assignment_backend.service.UserService;
import com.bright.assignment_backend.spec.UserSpec;
import com.bright.assignment_backend.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserImpl implements UserService {
    @Autowired
    private UserRepository repo ;

    @Autowired
    JwtUtil jwtUtil;
    @Autowired
    PasswordEncoder encoder;

    @Override
    public UserSpec.RegisterRes register(UserSpec.RegisterReq req) {
        UserSpec.RegisterRes res = new UserSpec.RegisterRes();
        if(repo.existsByEmail(req.getEmail())){
            res.setSuccess(false).setMessage("Email Existed");
            return res;
        }

        User user = new User()
                .setEmail(req.getEmail())
                .setName(req.getName())
                .setPassword(encoder.encode(req.getPassword()));
        repo.save(user);

        res.setSuccess(true).setMessage("User registered successfully");
        return res;
    }

    @Override
    public UserSpec.LoginRes login(UserSpec.LoginReq req) {
        UserSpec.LoginRes res = new UserSpec.LoginRes();
        User user = repo.findByEmail(req.getEmail());
        if(user == null) {
            return res.setSuccess(false).setMessage("Email not exist");
        }
        if(!encoder.matches(req.getPassword(),user.getPassword())){
            return res.setSuccess(false).setMessage("Password incorrect");
        }
        String jwt = jwtUtil.generateJwtToken(req.getEmail());
        res.setSuccess(true).setToken(jwt);
        return res;
    }



}
