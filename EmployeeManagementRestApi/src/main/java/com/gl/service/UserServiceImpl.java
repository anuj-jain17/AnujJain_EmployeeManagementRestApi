package com.gl.service;

import com.gl.model.User;
import com.gl.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    
    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }
}
