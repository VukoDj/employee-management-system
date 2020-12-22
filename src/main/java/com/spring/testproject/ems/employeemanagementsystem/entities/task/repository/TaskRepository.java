package com.spring.testproject.ems.employeemanagementsystem.entities.task.repository;

import com.spring.testproject.ems.employeemanagementsystem.entities.task.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {
}
