package com.spring.testproject.ems.employeemanagementsystem.entities.user.service;


import com.spring.testproject.ems.employeemanagementsystem.entities.user.model.User;
import com.spring.testproject.ems.employeemanagementsystem.entities.user.model.UserDetailsModel;
import com.spring.testproject.ems.employeemanagementsystem.entities.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.getUserByUsername(username);
        System.out.println(user);
        if(user == null){
            throw new UsernameNotFoundException("User does not exist");
        }
        return new UserDetailsModel(user);
    }
}
