package com.spring.testproject.ems.employeemanagementsystem.entities.employee.mapper;

import com.spring.testproject.ems.employeemanagementsystem.entities.employee.dto.EmployeeDto;
import com.spring.testproject.ems.employeemanagementsystem.entities.employee.model.Employee;
import com.spring.testproject.ems.employeemanagementsystem.entities.project.model.Project;
import com.spring.testproject.ems.employeemanagementsystem.entities.task.model.Task;

import java.util.*;


public class EmployeeMapper {


    public static EmployeeDto toEmployeeDto(Employee employee) {
        EmployeeDto employeeDto = new EmployeeDto()
                .setEmployee_id(employee.getId())
                .setFirstName(employee.getFirstName())
                .setLastName(employee.getLastName())
                .setDateOfBirth(employee.getDateOfBirth())
                .setHireDate(employee.getHireDate())
                .setEmailAddress(employee.getEmailAddress())
                .setJobTitle(employee.getJobTitle())
                .setPhoneNumber(employee.getPhoneNumber());

        if (employee.getDepartment() != null) {
            employeeDto.setDepartmentName(employee.getDepartment().getDepartmentName());
        }
        Set<String> projectsAssigned = new HashSet<>();
        Set<Project> projects = employee.getProjects();
        if (projects != null) {
            projects.forEach(project -> projectsAssigned.add(project.getProjectName()));
            employeeDto.setProjects(projectsAssigned);
        }
        List<String> tasksAssigned = new ArrayList<>();
        List<Task> tasks = employee.getTasks();
        if (tasks != null) {
            tasks.forEach(task -> tasksAssigned.add(task.getTaskName()));
            employeeDto.setTasks(tasksAssigned);
        }
        return employeeDto;
    }
}
