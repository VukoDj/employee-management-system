package com.spring.testproject.ems.employeemanagementsystem.entities.department.repository;

import com.spring.testproject.ems.employeemanagementsystem.entities.department.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    @Query(value = "select * from departments d "
            + "where lower(d.department_name) like lower(concat('%', :searchExpression , '%'))", nativeQuery = true)
    List<Department> search(@Param("searchExpression") String searchExpression);

    Optional<Department> findByDepartmentName(String departmentName);
}
