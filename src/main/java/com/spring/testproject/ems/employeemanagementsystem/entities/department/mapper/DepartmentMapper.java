package com.spring.testproject.ems.employeemanagementsystem.entities.department.mapper;

import com.spring.testproject.ems.employeemanagementsystem.entities.department.dto.DepartmentDto;
import com.spring.testproject.ems.employeemanagementsystem.entities.department.model.Department;


public class DepartmentMapper {

    public static DepartmentDto toDepartmentDto(Department department){
        return new DepartmentDto(
                department.getId(),
                department.getDepartmentName()
        );
    }
}
