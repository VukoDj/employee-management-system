package com.spring.testproject.ems.employeemanagementsystem.entities.department.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.spring.testproject.ems.employeemanagementsystem.entities.employee.model.Employee;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "department_id")
    private Integer id;

    @NotNull
    @Column(name = "department_name")
    private String departmentName;

    @OneToMany(mappedBy = "department")
    private List<Employee> employees;

}
