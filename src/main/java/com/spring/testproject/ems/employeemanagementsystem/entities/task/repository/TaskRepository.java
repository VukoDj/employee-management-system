package com.spring.testproject.ems.employeemanagementsystem.entities.task.repository;

import com.spring.testproject.ems.employeemanagementsystem.entities.task.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {

    @Query(value = "select * from tasks t "
            + "where lower(t.employee_id) = :employeeId;", nativeQuery = true)
    public List<Task> getAllTasksAssignedToEmployee(@Param("employeeId") Integer employeeId);
}
