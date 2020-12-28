package com.spring.testproject.ems.employeemanagementsystem.entities.employee.service;

import com.spring.testproject.ems.employeemanagementsystem.entities.employee.dto.EmployeeDto;
import com.spring.testproject.ems.employeemanagementsystem.entities.employee.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<EmployeeDto> getAllEmployees(String searchExpression);
    EmployeeDto getEmployeeById(Integer id);
    EmployeeDto addEmployee(Employee employee);
    List<EmployeeDto> getEmployeesFromDepartment(Integer departmentId);
    EmployeeDto updateEmployee(Employee employee, Integer employeeId);
    EmployeeDto assignProjectToEmployee(Integer employeeId, Integer projectId);
    void deleteEmployeeById(Integer employeeId);

}
