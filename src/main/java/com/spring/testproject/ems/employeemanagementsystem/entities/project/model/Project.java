package com.spring.testproject.ems.employeemanagementsystem.entities.project.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spring.testproject.ems.employeemanagementsystem.entities.employee.model.Employee;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "project")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "project_id")
    private Integer id;
    @NotNull
    @Column(name = "project_name")
    private String projectName;
    @Column(name = "project_description")
    private String projectDescription;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "projects")
    private Set<Employee> employees = new HashSet<>();
}
