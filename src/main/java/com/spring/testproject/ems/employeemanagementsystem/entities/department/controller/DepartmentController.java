package com.spring.testproject.ems.employeemanagementsystem.entities.department.controller;

import com.spring.testproject.ems.employeemanagementsystem.entities.department.dto.DepartmentDto;
import com.spring.testproject.ems.employeemanagementsystem.entities.department.model.Department;
import com.spring.testproject.ems.employeemanagementsystem.entities.department.service.DepartmentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentServiceImp departmentService;

    // Get all departments
    // searchExpression can be used to filter Departments by name
    @GetMapping("/departments")
    public List<DepartmentDto> getAllDepartments(@RequestParam(value = "searchExpression", required = false) String searchExpression){
        return departmentService.getAllDepartments(searchExpression);
    }

    // Create department
    @PostMapping("/departments")
    public DepartmentDto addDepartment(@RequestBody Department department){
        return departmentService.addDepartment(department);
    }

    // Get department by id
    @GetMapping("/departments/{departmentId}")
    public DepartmentDto getDepartmentById(@PathVariable Integer departmentId){
        return departmentService.getDepartmentById(departmentId);
    }

    // Update department
    @PutMapping("/departments/{departmentId}")
    public DepartmentDto updateDepartment(@RequestBody Department department, @PathVariable Integer departmentId){
        return departmentService.updateDepartment(department, departmentId);
    }

    // Deleting employee
    @DeleteMapping("/departments/{departmentId}")
    public ResponseEntity deleteDepartmentById(@PathVariable int departmentId){
        departmentService.deleteDepartmentById(departmentId);
        return new ResponseEntity<>("Department is successfully deleted", HttpStatus.OK);
    }

}
