package com.spring.testproject.ems.employeemanagementsystem.entities.employee.controller;

import com.spring.testproject.ems.employeemanagementsystem.entities.department.service.DepartmentServiceImp;
import com.spring.testproject.ems.employeemanagementsystem.entities.employee.dto.EmployeeDto;
import com.spring.testproject.ems.employeemanagementsystem.entities.employee.model.Employee;
import com.spring.testproject.ems.employeemanagementsystem.entities.employee.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {


    @Autowired
    private EmployeeServiceImpl employeeService;
    
    @Autowired
    private DepartmentServiceImp departmentService;

    // Get all employees
    // With searchExpression we can search employees by first or last name
    @GetMapping("/employees")
    public List<EmployeeDto> getAllEmployees(@RequestParam(value = "searchExpression", required = false) String searchExpression){
        return employeeService.getAllEmployees(searchExpression);
    }

    // Get employee by Id
    @GetMapping("/employees/{employeeId}")
    public EmployeeDto getEmployee(@PathVariable Integer employeeId){
        return employeeService.getEmployeeById(employeeId);
    }

    // Get all employees from specific department
    @GetMapping("/employees/departments/{departmentId}")
    public List<EmployeeDto> getEmployeesFromDepartment(@PathVariable Integer departmentId){
        return employeeService.getEmployeesFromDepartment(departmentId);
    }

    // Creating new employee
    @PostMapping("/employees")
    public EmployeeDto addEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    // Updating employee
    @PutMapping("/employees/{employeeId}")
    public EmployeeDto updateEmployee(@RequestBody Employee employee, @PathVariable Integer employeeId){
        return employeeService.updateEmployee(employee, employeeId);
    }

    // Assigning employee to project with specific Id
    @PutMapping("/employees/{employeeId}/projects/{projectId}")
    public void assignProjectToEmployee(@PathVariable Integer employeeId, @PathVariable Integer projectId){
        employeeService.assignProjectToEmployee(employeeId, projectId);
    }

    // Deleting employee
    @DeleteMapping("employees/{employee_id}")
    public ResponseEntity deleteEmployeeById(@PathVariable int employee_id){
        employeeService.deleteEmployeeById(employee_id);
        return new ResponseEntity<>("Employee is successfully deleted", HttpStatus.OK);
    }

}
