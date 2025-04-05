package com.bright.assignment_backend.service;

import com.bright.assignment_backend.entity.User;
import com.bright.assignment_backend.service.spec.UserSpec;

public interface UserService {
    public UserSpec.RegisterRes register(UserSpec.RegisterReq req);

}
