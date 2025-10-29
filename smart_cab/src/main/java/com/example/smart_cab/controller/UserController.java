package com.example.smart_cab.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.smart_cab.entity.User;
import com.example.smart_cab.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController{
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User>getAllUsers(){
        return userService.getAllUsers();
    }
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id){
            return userService.getUserById(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id,@RequestBody User userDetails){
        return userService.updateUser(id,userDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }
}
