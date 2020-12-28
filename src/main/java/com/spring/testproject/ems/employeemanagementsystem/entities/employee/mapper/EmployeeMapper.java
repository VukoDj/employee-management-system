package com.spring.testproject.ems.employeemanagementsystem.entities.employee.mapper;

import com.spring.testproject.ems.employeemanagementsystem.entities.employee.dto.EmployeeDto;
import com.spring.testproject.ems.employeemanagementsystem.entities.employee.model.Employee;


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
            employeeDto.setDepartmentName(employee.getDepartment().getDepartmentName());
        }
        return employeeDto;
    }
}
