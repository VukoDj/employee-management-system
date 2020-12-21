package com.spring.testproject.ems.employeemanagementsystem.entities.employee.controller;

import com.spring.testproject.ems.employeemanagementsystem.entities.department.service.DepartmentServiceImp;
import com.spring.testproject.ems.employeemanagementsystem.entities.employee.dto.EmployeeDto;
import com.spring.testproject.ems.employeemanagementsystem.entities.employee.model.Employee;
import com.spring.testproject.ems.employeemanagementsystem.entities.employee.service.EmployeeServiceImpl;
import com.spring.testproject.ems.employeemanagementsystem.entities.project.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {


    @Autowired
    private EmployeeServiceImpl employeeService;
    
    @Autowired
    private DepartmentServiceImp departmentService;

    // displaying list of all employees
    @GetMapping("/employees")
    public List<EmployeeDto> getAllEmployee(@RequestParam(value = "searchExpression", required = false) String searchExpression){
        return employeeService.getAllEmployees(searchExpression);
    }

    // displaying employee by id
    @GetMapping("/employees/{employeeId}")
    public EmployeeDto getEmployee(@PathVariable Integer employeeId){
        return employeeService.getEmployeeById(employeeId);
    }

    @GetMapping("/employees/departments/{departmentId}")
    public List<EmployeeDto> getEmployeesFromDepartment(@PathVariable Integer departmentId){
        return employeeService.getEmployeesFromDepartment(departmentId);
    }

//    @GetMapping("employees/projects/{projectId}")
//    public List<EmployeeDto> getEmployeesByProjectId(@PathVariable Integer projectId){
//        return employeeService.getEmployeesByProjectId(projectId);
//    }

    // inserting employee
    @PostMapping("/employees")
    public EmployeeDto addEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    //updating employee by id
    @PutMapping("/employees/{employeeId}")
    public void updateEmployee(@RequestBody Employee e, @PathVariable Integer employeeId){
        employeeService.updateEmployee(e, employeeId);
    }

    @PutMapping("/employees/{employeeId}/projects/{projectId}")
    public void assignProjectToEmployee(@PathVariable Integer employeeId, @PathVariable Integer projectId){
        employeeService.assignProjectToEmployee(employeeId, projectId);
    }

    // deleting all employees
    @DeleteMapping("/employees")
    public void deleteAllEmployees(){
        employeeService.deleteAllEmployees();
    }

    // deleting employee by id
    @DeleteMapping("employees/{id}")
    public void deleteEmployeeByID(@RequestBody Employee e, @PathVariable int id){
        employeeService.deleteEmployeeByID(id);
    }

}
