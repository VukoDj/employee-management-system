package com.spring.testproject.ems.employeemanagementsystem.entities.employee.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spring.testproject.ems.employeemanagementsystem.entities.department.model.Department;
import com.spring.testproject.ems.employeemanagementsystem.entities.project.model.Project;
import com.spring.testproject.ems.employeemanagementsystem.entities.task.model.Task;
import com.sun.istack.NotNull;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer id;

    @NotNull
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "date_of_birth")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date dateOfBirth;

    @Column(name = "email_address")
    private String emailAddress;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "hire_date")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date hireDate;

    @Column(name = "job_title")
    private String jobTitle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    @NotNull
    private Department department;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "employees_projects",
            joinColumns = {@JoinColumn(name = "employee_id")},
            inverseJoinColumns = {@JoinColumn(name = "project_id")})
    private Set<Project> projects = new HashSet<>();

    @OneToMany(mappedBy = "assignedTo")
    private Set<Task> tasks = new HashSet<>();

}

