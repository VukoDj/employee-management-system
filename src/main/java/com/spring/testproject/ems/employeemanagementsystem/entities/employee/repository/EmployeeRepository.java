package com.spring.testproject.ems.employeemanagementsystem.entities.employee.repository;


import com.spring.testproject.ems.employeemanagementsystem.entities.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {


    @Query(value = "select * from employees e "
            + "where lower(e.first_name) like lower(concat('%', :searchExpression, '%'))"
            + "or lower(e.last_name) like lower(concat('%', :searchExpression, '%'))", nativeQuery = true)
    public List<Employee> search(@Param("searchExpression") String searchExpression);


    @Query(value = "select * from employees e "
            + "where department_id = :departmentId;", nativeQuery = true)
    public List<Employee> getEmployeesFromDepartment(@Param("departmentId") Integer departmentId);

//    @Query(value = "select * from employees e "
//            + "where department_id = :departmentId;", nativeQuery = true)
//    public List<Employee> getEmployeesByProjectId(@Param("projectId") Integer departmentId);

}
