package com.spring.testproject.ems.employeemanagementsystem.entities.employee.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.Date;



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
}
