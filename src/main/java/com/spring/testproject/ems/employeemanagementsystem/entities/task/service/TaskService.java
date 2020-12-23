package com.spring.testproject.ems.employeemanagementsystem.entities.task.service;

import com.spring.testproject.ems.employeemanagementsystem.entities.task.dto.TaskDto;
import com.spring.testproject.ems.employeemanagementsystem.entities.task.model.Task;

import java.util.List;

public interface TaskService {

    TaskDto addTask(Task task);
    List<TaskDto> getAllTasks();
    TaskDto getTaskById(Integer taskId);
    TaskDto updateTask(Task task, Integer taskId);
    TaskDto assignTaskToEmployee(Integer taskId, Integer employeeId);

}
