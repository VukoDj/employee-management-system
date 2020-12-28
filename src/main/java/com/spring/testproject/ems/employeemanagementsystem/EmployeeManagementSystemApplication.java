package com.spring.testproject.ems.employeemanagementsystem;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.testproject.ems.employeemanagementsystem.entities.user.model.UserRole;
import com.spring.testproject.ems.employeemanagementsystem.entities.user.model.User;
import com.spring.testproject.ems.employeemanagementsystem.entities.user.repository.UserRepository;
import com.spring.testproject.ems.employeemanagementsystem.entities.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class EmployeeManagementSystemApplication{

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private static UserService userService;

	@Autowired
	private static UserRepository userRepository;

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder(){
		return new BCryptPasswordEncoder();
	}

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementSystemApplication.class, args); }
}
