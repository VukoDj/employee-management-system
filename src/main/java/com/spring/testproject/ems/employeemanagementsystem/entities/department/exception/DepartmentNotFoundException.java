package com.spring.testproject.ems.employeemanagementsystem.entities.department.exception;

public class DepartmentNotFoundException extends RuntimeException{

    public DepartmentNotFoundException(){
        super("Department does not exist");
    }
}
