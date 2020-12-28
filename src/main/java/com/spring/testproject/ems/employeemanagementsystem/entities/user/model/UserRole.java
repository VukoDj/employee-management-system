package com.spring.testproject.ems.employeemanagementsystem.entities.user.model;

import com.spring.testproject.ems.employeemanagementsystem.entities.employee.model.Employee;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

public enum UserRole {
    ADMIN, PROJECT_MANAGER, EMPLOYEE
}


