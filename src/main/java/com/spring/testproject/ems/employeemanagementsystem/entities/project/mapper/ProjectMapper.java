package com.spring.testproject.ems.employeemanagementsystem.entities.project.mapper;

import com.spring.testproject.ems.employeemanagementsystem.entities.project.dto.ProjectDto;
import com.spring.testproject.ems.employeemanagementsystem.entities.project.model.Project;

public class ProjectMapper {
    public static ProjectDto toProjectDto(Project project){
        ProjectDto projectDto = new ProjectDto()
                .setProjectId(project.getId())
                .setProjectName(project.getProjectName())
                .setProjectDescription(project.getProjectDescription());

        if (project.getEmployees() != null) {
            project.setEmployees(project.getEmployees());
        }
        return projectDto;
    }
}
