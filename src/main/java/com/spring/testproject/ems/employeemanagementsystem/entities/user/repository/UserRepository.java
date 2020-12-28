package com.spring.testproject.ems.employeemanagementsystem.entities.user.repository;

import com.spring.testproject.ems.employeemanagementsystem.entities.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

    User getUserByUsername(String username);
}
