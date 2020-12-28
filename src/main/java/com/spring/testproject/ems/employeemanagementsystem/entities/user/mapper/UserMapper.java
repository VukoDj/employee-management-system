package com.spring.testproject.ems.employeemanagementsystem.entities.user.mapper;


import com.spring.testproject.ems.employeemanagementsystem.entities.user.dto.UserDto;
import com.spring.testproject.ems.employeemanagementsystem.entities.user.model.User;
import com.spring.testproject.ems.employeemanagementsystem.entities.user.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class UserMapper{

    @Autowired
    private static BCryptPasswordEncoder bCryptPasswordEncoder;

    public static UserDto toUserDto(User user) {
        return new UserDto()
                .setUsername(user.getUsername())
                .setEmail(user.getEmail())
                .setRole(user.getUserRole().toString())
                .setPassword(user.getPassword());
    }

    public static User toUser(UserDto userDto){
        return new User()
                .setEmail(userDto.getEmail())
                .setPassword(userDto.getPassword())
                .setUserRole(UserRole.valueOf(userDto.getRole()))
                .setUsername(userDto.getUsername());
    }
}
