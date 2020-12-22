package com.spring.testproject.ems.employeemanagementsystem.entities.task.mapper;


import com.spring.testproject.ems.employeemanagementsystem.entities.task.dto.TaskDto;
import com.spring.testproject.ems.employeemanagementsystem.entities.task.model.Task;

public class TaskMapper {
    public TaskDto toTaskDto(Task task){
        TaskDto taskDto = new TaskDto()
                .setTaskId(task.getId())
                .setTaskName(task.getTaskName())
                .setProjectName(task.getProject().getProjectName())
                .setPriority(task.getPriority());
        if (task.getPriority() != null){
            taskDto.setEmployeeFullName(task.getAssignedTo().getFirstName() + " " + task.getAssignedTo().getLastName());
        }
    return taskDto;
    }
}
