package com.spring.testproject.ems.employeemanagementsystem.entities.department.service;

import com.spring.testproject.ems.employeemanagementsystem.entities.department.dto.DepartmentDto;
import com.spring.testproject.ems.employeemanagementsystem.entities.department.model.Department;
import java.util.List;

public interface DepartmentService {

    List<DepartmentDto> getAllDepartments(String searchExpression);
    DepartmentDto getDepartmentById(Integer departmentId);
    DepartmentDto addDepartment(Department department);
    DepartmentDto updateDepartment(Department department, Integer departmentId);
    void deleteDepartmentById(Integer departmentId);
 }
