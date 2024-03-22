package com.gl.service;

import com.gl.model.User;

public interface UserService {
    User getUserByUsername(String username);
    User addUser(User user);
}
