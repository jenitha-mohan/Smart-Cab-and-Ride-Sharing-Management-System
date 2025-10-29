package com.example.smart_cab.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.smart_cab.entity.User;
import com.example.smart_cab.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    //get all users
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }
    
    public User createUser(User user){
        return userRepository.save(user);
    }

    public User updateUser(Long id,User userDetails){
        User user=userRepository.findById(id).orElseThrow();
        if(userDetails.getName()!=null)
           user.setName(userDetails.getName());
        if(userDetails.getEmail()!=null)
           user.setEmail(userDetails.getEmail());
        if(userDetails.getPhone()!=null)
           user.setPhone(userDetails.getPhone());
        if(userDetails.getPassword()!=null)
           user.setPassword(userDetails.getPassword());
        
        return userRepository.save(user);
        
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }


    
}
