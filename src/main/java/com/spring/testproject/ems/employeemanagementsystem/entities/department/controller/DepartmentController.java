package com.spring.testproject.ems.employeemanagementsystem.entities.department.controller;

import com.spring.testproject.ems.employeemanagementsystem.entities.department.dto.DepartmentDto;
import com.spring.testproject.ems.employeemanagementsystem.entities.department.model.Department;
import com.spring.testproject.ems.employeemanagementsystem.entities.department.service.DepartmentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentServiceImp departmentService;

    @GetMapping("/departments")
    public List<DepartmentDto> getAllDepartments(@RequestParam(value = "searchExpression", required = false) String searchExpression){
        return departmentService.getAllDepartments(searchExpression);
    }

    @PostMapping("/departments")
    public DepartmentDto addDepartment(@RequestBody Department department){
        return departmentService.addDepartment(department);
    }

    @GetMapping("/departments/{departmentId}")
    public DepartmentDto getDepartmentById(@PathVariable Integer departmentId){
        return departmentService.getDepartmentById(departmentId);
    }

    @PutMapping("/departments/{departmentId}")
    public DepartmentDto updateDepartment(@RequestBody Department department, @PathVariable Integer departmentId){
        return departmentService.updateDepartment(department, departmentId);
    }
}
