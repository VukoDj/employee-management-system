package com.spring.testproject.ems.employeemanagementsystem.entities.department.service;

import com.spring.testproject.ems.employeemanagementsystem.entities.department.dto.DepartmentDto;
import com.spring.testproject.ems.employeemanagementsystem.entities.department.exception.DepartmentNotFoundException;
import com.spring.testproject.ems.employeemanagementsystem.entities.department.mapper.DepartmentMapper;
import com.spring.testproject.ems.employeemanagementsystem.entities.department.repository.DepartmentRepository;
import com.spring.testproject.ems.employeemanagementsystem.entities.department.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImp implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<DepartmentDto> getAllDepartments(String searchExpression) {

        List<Department> departments;
        if (searchExpression != null) {
            departments = departmentRepository.search(searchExpression);
        } else {
            departments = departmentRepository.findAll();
        }

        if (!departments.isEmpty()) {
            return departments
                    .stream()
                    .map(DepartmentMapper::toDepartmentDto)
                    .collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }
    }


    @Override
    public DepartmentDto getDepartmentById(Integer departmentId) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(DepartmentNotFoundException::new);
        return DepartmentMapper.toDepartmentDto(department);
    }

    @Override
    public DepartmentDto addDepartment(Department department) {
        return DepartmentMapper.toDepartmentDto(departmentRepository.save(department));
    }

    @Override
    public DepartmentDto updateDepartment(Department department, Integer departmentId) {
        if(departmentRepository.findById(departmentId).isPresent()) {
            department.setId(departmentId);
        }else{
            throw new DepartmentNotFoundException();
        }
        return DepartmentMapper.toDepartmentDto(departmentRepository.save(department));
    }

    @Override
    public void deleteDepartmentById(Integer departmentId) {
        departmentRepository.deleteById(departmentId);
    }


}
