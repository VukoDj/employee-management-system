package com.spring.testproject.ems.employeemanagementsystem.entities.department.repository;

import com.spring.testproject.ems.employeemanagementsystem.entities.department.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    @Query(value = "select * from department d "
            + "where lower(d.department_name) like lower(concat('%', :searchExpression , '%'))", nativeQuery = true)
    public List<Department> search(@Param("searchExpression") String searchExpression);

}
