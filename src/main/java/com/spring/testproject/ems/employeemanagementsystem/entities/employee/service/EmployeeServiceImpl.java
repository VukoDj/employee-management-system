package com.spring.testproject.ems.employeemanagementsystem.entities.employee.service;

import com.spring.testproject.ems.employeemanagementsystem.entities.department.repository.DepartmentRepository;
import com.spring.testproject.ems.employeemanagementsystem.entities.employee.dto.EmployeeDto;
import com.spring.testproject.ems.employeemanagementsystem.entities.employee.model.Employee;
import com.spring.testproject.ems.employeemanagementsystem.entities.employee.mapper.EmployeeMapper;
import com.spring.testproject.ems.employeemanagementsystem.entities.employee.repository.EmployeeRepository;
import com.spring.testproject.ems.employeemanagementsystem.entities.project.model.Project;
import com.spring.testproject.ems.employeemanagementsystem.entities.project.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<EmployeeDto> getAllEmployees(String searchExpression) {
        List<Employee> employees;
        if(searchExpression != null) {
            employees = employeeRepository.search(searchExpression);
        }else{
            employees = employeeRepository.findAll();
        }
        if (!employees.isEmpty()) {
            return employees
                    .stream()
                    .map(EmployeeMapper::toEmployeeDto)
                    .collect(Collectors.toList());

        }else{
            return Collections.emptyList();
        }
    }


    @Override
    public List<EmployeeDto> getEmployeesFromDepartment(Integer departmentId){
        List<Employee> employees = employeeRepository.getEmployeesFromDepartment(departmentId);
        if(!employees.isEmpty()){
            return employees
                    .stream()
                    .map(EmployeeMapper::toEmployeeDto)
                    .collect(Collectors.toList());
        }else{
            return Collections.emptyList();
        }
    }

    @Override
    public EmployeeDto getEmployeeById(Integer id){
        return employeeRepository.findById(id).map(EmployeeMapper::toEmployeeDto).orElse(null);
    }

    @Override
    public EmployeeDto addEmployee(Employee employee) {
        return EmployeeMapper.toEmployeeDto(employeeRepository.save(employeeRepository.save(employee)));
    }

    @Override
    public EmployeeDto updateEmployee(Employee employee, Integer employeeId){
        if(employeeRepository.findById(employeeId).isPresent()){
            employee.setId(employeeId);
        }
        return EmployeeMapper.toEmployeeDto(employeeRepository.save(employee));
    }

    @Override
    public EmployeeDto assignProjectToEmployee(Integer employeeId, Integer projectId) {
        Project project = projectRepository.findById(projectId).get();
        Employee employee = employeeRepository.findById(employeeId).get();
        employee.getProjects().add(project);
        return EmployeeMapper.toEmployeeDto(employeeRepository.save(employee));
    }

//    @Override
//    public List<EmployeeDto> getEmployeesByProjectId(Integer projectId) {
//        List<Employee> employees = employeeRepository.getEmployeesByProjectId(projectId);
//        if(!employees.isEmpty()){
//            return employees
//                    .stream()
//                    .map(EmployeeMapper::toEmployeeDto)
//                    .collect(Collectors.toList());
//        }else{
//            return Collections.emptyList();
//        }
//    }

    public void deleteAllEmployees(){
        employeeRepository.deleteAll();
    }

    public void deleteEmployeeByID(int id){
        employeeRepository.deleteById(id);
    }

}

