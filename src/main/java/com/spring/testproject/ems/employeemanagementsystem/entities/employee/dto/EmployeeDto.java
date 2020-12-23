package com.spring.testproject.ems.employeemanagementsystem.entities.employee.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.spring.testproject.ems.employeemanagementsystem.entities.department.dto.DepartmentDto;
import com.spring.testproject.ems.employeemanagementsystem.entities.department.model.Department;
import com.spring.testproject.ems.employeemanagementsystem.entities.project.dto.ProjectDto;
import com.spring.testproject.ems.employeemanagementsystem.entities.project.model.Project;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString
public class EmployeeDto {

    private Integer employee_id;
    private String firstName;
    private String lastName;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date dateOfBirth;
    private String emailAddress;
    private String phoneNumber;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date hireDate;
    private String jobTitle;
    private String departmentName;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date createdAt;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date modifiedAt;
    private Set<String> projects;
    private Set<String> tasks;
}
