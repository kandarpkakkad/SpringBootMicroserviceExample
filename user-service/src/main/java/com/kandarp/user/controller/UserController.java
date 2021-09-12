package com.kandarp.user.controller;

import com.kandarp.user.entity.User;
import com.kandarp.user.service.UserService;
import com.kandarp.user.value.objects.ResponseTemplateValueObjects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/id/{userId}")
    public User findByUserId(@PathVariable("userId") Long userId) {
        return userService.findByUserId(userId);
    }

    @GetMapping("/")
    public ArrayList<User> findUsers() {
        return userService.findUsers();
    }

    @GetMapping("/{userId}")
    public ResponseTemplateValueObjects getUserWithDepartment(@PathVariable("userId") Long userId) {
        return userService.getUserWithDepartment(userId);
    }

    @PostMapping("/")
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }
}
