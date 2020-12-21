package com.spring.testproject.ems.employeemanagementsystem.entities.project.repository;

import com.spring.testproject.ems.employeemanagementsystem.entities.department.model.Department;
import com.spring.testproject.ems.employeemanagementsystem.entities.project.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

    @Query(value = "select * from project p "
            + "where lower(d.project_name) like lower(concat('%', :searchExpression , '%'))", nativeQuery = true)
    public List<Project> search(@Param("searchExpression") String searchExpression);
}
