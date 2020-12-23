package com.spring.testproject.ems.employeemanagementsystem.entities.task.controller;

import com.spring.testproject.ems.employeemanagementsystem.entities.task.dto.TaskDto;
import com.spring.testproject.ems.employeemanagementsystem.entities.task.model.Task;
import com.spring.testproject.ems.employeemanagementsystem.entities.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/tasks")
    public TaskDto addTask(@RequestBody Task task){
        return taskService.addTask(task);
    }

    @GetMapping("/tasks")
    public List<TaskDto> getAllTasks(){
        return taskService.getAllTasks();
    }

    @GetMapping("/tasks/{task_id}")
    public TaskDto getAllTasks(@PathVariable Integer taskId){
        return taskService.getTaskById(taskId);
    }

    @PutMapping("/tasks/{task_id}")
    public TaskDto updateTask(@RequestBody Task task, @PathVariable Integer taskId){
        return taskService.updateTask(task, taskId);
    }

    @PutMapping("/tasks/{taskId}/employees/{employeeId}")
    public TaskDto assignTaskToEmployee(@PathVariable Integer taskId, @PathVariable Integer employeeId){
        return taskService.assignTaskToEmployee(taskId, employeeId);
    }
}
