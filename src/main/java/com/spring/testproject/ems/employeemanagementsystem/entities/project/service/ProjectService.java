package com.spring.testproject.ems.employeemanagementsystem.entities.project.service;

import com.spring.testproject.ems.employeemanagementsystem.entities.project.dto.ProjectDto;
import com.spring.testproject.ems.employeemanagementsystem.entities.project.model.Project;

import java.util.List;

public interface ProjectService {

    ProjectDto addProject(Project project);
    List<ProjectDto> getAllProjects(String searchExpression);
    ProjectDto getProjectById(Integer projectId);
    ProjectDto updateProject(Project project, Integer projectId);
}
