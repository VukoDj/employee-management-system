package com.spring.testproject.ems.employeemanagementsystem.entities.task.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.NOT_FOUND)
public class TaskNotFoundException extends RuntimeException{
    public TaskNotFoundException(String message){
        super("Task with id: " +  message + " does not exist");
    }
}