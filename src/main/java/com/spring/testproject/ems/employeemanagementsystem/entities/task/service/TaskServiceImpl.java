package com.spring.testproject.ems.employeemanagementsystem.entities.task.service;

import com.spring.testproject.ems.employeemanagementsystem.entities.employee.model.Employee;
import com.spring.testproject.ems.employeemanagementsystem.entities.employee.repository.EmployeeRepository;
import com.spring.testproject.ems.employeemanagementsystem.entities.task.dto.TaskDto;
import com.spring.testproject.ems.employeemanagementsystem.entities.task.mapper.TaskMapper;
import com.spring.testproject.ems.employeemanagementsystem.entities.task.model.Task;
import com.spring.testproject.ems.employeemanagementsystem.entities.task.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public TaskDto addTask(Task task) {
        return TaskMapper.toTaskDto(taskRepository.save(task));
    }

    @Override
    public List<TaskDto> getAllTasks() {
       List<Task> tasks = taskRepository.findAll();
       if(!tasks.isEmpty()){
           return tasks
                   .stream()
                   .map(TaskMapper::toTaskDto)
                   .collect(Collectors.toList());
       }else{
           return Collections.emptyList();
       }
    }

    @Override
    public TaskDto getTaskById(Integer taskId) {
        return taskRepository.findById(taskId).map(TaskMapper::toTaskDto).orElse(null);
    }

    @Override
    public TaskDto updateTask(Task task, Integer taskId) {
        if(taskRepository.findById(taskId).isPresent()){
            task.setId(taskId);
        }

        return TaskMapper.toTaskDto(taskRepository.save(task));
    }

    @Override
    public TaskDto assignTaskToEmployee(Integer taskId, Integer employeeId) {
        Task task = taskRepository.findById(taskId).get();
        Employee employee = employeeRepository.findById(employeeId).get();
        task.setAssignedTo(employee);
        return TaskMapper.toTaskDto(taskRepository.save(task));
    }

    @Override
    public List<TaskDto> getAllTasksAssignedToEmployee(Integer employee_id) {
        List<Task> tasks = taskRepository.getAllTasksAssignedToEmployee(employee_id);
        if(!tasks.isEmpty()){
            return tasks
                    .stream()
                    .map(TaskMapper::toTaskDto)
                    .collect(Collectors.toList());
        }else{
            return Collections.emptyList();
        }
    }
}
