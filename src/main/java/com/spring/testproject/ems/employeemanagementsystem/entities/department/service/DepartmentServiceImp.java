package com.spring.testproject.ems.employeemanagementsystem.entities.department.service;

import com.spring.testproject.ems.employeemanagementsystem.entities.department.dto.DepartmentDto;
import com.spring.testproject.ems.employeemanagementsystem.entities.department.mapper.DepartmentMapper;
import com.spring.testproject.ems.employeemanagementsystem.entities.department.repository.DepartmentRepository;
import com.spring.testproject.ems.employeemanagementsystem.entities.department.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImp implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<DepartmentDto> getAllDepartments(String searchExpression){

        List<Department> departments;
        if(searchExpression != null){
            departments =departmentRepository.search(searchExpression);
        }else{
            departments = departmentRepository.findAll();
        }

        if(!departments.isEmpty()){
            return departments
                    .stream()
                    .map(DepartmentMapper::toDepartmentDto)
                    .collect(Collectors.toList());
        }else{
            return Collections.emptyList();
        }
    }


    @Override
    public DepartmentDto getDepartmentById(Integer departmentId){
        Optional<Department> employee = departmentRepository.findById(departmentId);
        return employee.map(DepartmentMapper::toDepartmentDto).orElse(null);
    }

    @Override
    public DepartmentDto addDepartment(Department department){
        return DepartmentMapper.toDepartmentDto(departmentRepository.save(department));
    }

    @Override
    public DepartmentDto updateDepartment(Department department, Integer departmentId){
        Department old_department = departmentRepository.findById(departmentId).get();
        department.setId(departmentId);
        return DepartmentMapper.toDepartmentDto(departmentRepository.save(department));
    }

    @Override
    public DepartmentDto getDepartmentByName(String departmentName) {
        Department department = departmentRepository.findByDepartmentName(departmentName).orElse(null);
        return DepartmentMapper.toDepartmentDto(department);
    }


    public void deleteDepartment(Integer id){
        departmentRepository.deleteById(id);
    }

}
