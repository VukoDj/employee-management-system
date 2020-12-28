package com.spring.testproject.ems.employeemanagementsystem.entities.project.dto;

import com.spring.testproject.ems.employeemanagementsystem.entities.employee.model.Employee;
import lombok.*;
import lombok.experimental.Accessors;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString
public class ProjectDto {

    private Integer projectId;
    private String projectName;
    private String projectDescription;
    private Set<Employee> employees;
}
