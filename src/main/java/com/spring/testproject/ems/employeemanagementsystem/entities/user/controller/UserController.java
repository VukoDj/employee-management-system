package com.spring.testproject.ems.employeemanagementsystem.entities.user.controller;

import com.spring.testproject.ems.employeemanagementsystem.entities.user.dto.UserDto;
import com.spring.testproject.ems.employeemanagementsystem.entities.user.model.User;
import com.spring.testproject.ems.employeemanagementsystem.entities.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public UserDto createUser(@RequestBody UserDto userDto){
        return userService.createUser(userDto);
    }

    @GetMapping("/users")
    public List<UserDto> getAllUsers(){
        return userService.getAllUsers();
    }
}
