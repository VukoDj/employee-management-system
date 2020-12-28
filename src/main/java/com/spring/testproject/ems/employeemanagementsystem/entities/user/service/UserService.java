package com.spring.testproject.ems.employeemanagementsystem.entities.user.service;

import com.spring.testproject.ems.employeemanagementsystem.entities.employee.dto.EmployeeDto;
import com.spring.testproject.ems.employeemanagementsystem.entities.employee.mapper.EmployeeMapper;
import com.spring.testproject.ems.employeemanagementsystem.entities.employee.model.Employee;
import com.spring.testproject.ems.employeemanagementsystem.entities.user.dto.UserDto;
import com.spring.testproject.ems.employeemanagementsystem.entities.user.mapper.UserMapper;
import com.spring.testproject.ems.employeemanagementsystem.entities.user.model.User;
import com.spring.testproject.ems.employeemanagementsystem.entities.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public UserDto createUser(UserDto userDto){
        String encryptedPassword = encoder.encode(userDto.getPassword());
        userDto.setPassword(encryptedPassword);
        User newUser = userRepository.save(UserMapper.toUser(userDto));
        return UserMapper.toUserDto(newUser );
    }

    public List<UserDto> getAllUsers(){
        List<User> users = userRepository.findAll();
        if(!users.isEmpty()){
            return users
                    .stream()
                    .map(UserMapper::toUserDto)
                    .collect(Collectors.toList());
        }else{
            return Collections.emptyList();
        }
    }
}
