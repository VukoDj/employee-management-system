package com.spring.testproject.ems.employeemanagementsystem.entities.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProjectNotFoundException extends RuntimeException{

    public ProjectNotFoundException(String message){
        super("Project with id: " +  message + " does not exist");
    }
}
