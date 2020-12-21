package com.spring.testproject.ems.employeemanagementsystem.entities.employee.mapper;

import com.spring.testproject.ems.employeemanagementsystem.entities.department.mapper.DepartmentMapper;
import com.spring.testproject.ems.employeemanagementsystem.entities.employee.dto.EmployeeDto;
import com.spring.testproject.ems.employeemanagementsystem.entities.employee.model.Employee;
import com.spring.testproject.ems.employeemanagementsystem.entities.project.mapper.ProjectMapper;

import java.util.stream.Collectors;


public class EmployeeMapper {


    public static EmployeeDto toEmployeeDto(Employee employee) {
        EmployeeDto employeeDto = new EmployeeDto()
                .setEmployee_id(employee.getId())
                .setFirstName(employee.getFirstName())
                .setLastName(employee.getLastName())
                .setDateOfBirth(employee.getDateOfBirth())
                .setHireDate(employee.getHireDate())
                .setEmailAddress(employee.getEmailAddress())
                .setJobTitle(employee.getJobTitle())
                .setPhoneNumber(employee.getPhoneNumber());

        if (employee.getDepartment() != null) {
            employeeDto.setDepartment(DepartmentMapper.toDepartmentDto(employee.getDepartment()));
        }
        if (employee.getProjects() != null) {
            employeeDto.setProjects(
                    employee.getProjects()
                    .stream()
                    .map(ProjectMapper::toProjectDto)
                    .collect(Collectors.toSet())
            );
        }

        return employeeDto;
    }
}
