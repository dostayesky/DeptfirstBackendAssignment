package com.bright.assignment_backend.service;

import com.bright.assignment_backend.spec.UserSpec;

public interface UserService {
    public UserSpec.RegisterRes register(UserSpec.RegisterReq req);
    public UserSpec.LoginRes login(UserSpec.LoginReq req);
}
