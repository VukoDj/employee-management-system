package com.spring.testproject.ems.employeemanagementsystem.entities.department.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DepartmentDto {

    private Integer id;

    private String departmentName;
}
