package com.gl.controller;

import com.gl.model.User;
import com.gl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }
    
    @PostMapping
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }
}
