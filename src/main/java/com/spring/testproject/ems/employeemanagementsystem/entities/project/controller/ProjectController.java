package com.spring.testproject.ems.employeemanagementsystem.entities.project.controller;

import com.spring.testproject.ems.employeemanagementsystem.entities.project.dto.ProjectDto;
import com.spring.testproject.ems.employeemanagementsystem.entities.project.model.Project;
import com.spring.testproject.ems.employeemanagementsystem.entities.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping("/projects")
    public ProjectDto addProject(@RequestBody Project project) {
        return projectService.addProject(project);
    }

    @GetMapping("/projects")
    public List<ProjectDto> getAllProjects(@RequestParam(value = "searchExpression", required = false) String searchExpression) {
        return projectService.getAllProjects(searchExpression);
    }

    @GetMapping("/projects/{projectId}")
    public ProjectDto getProjectById(@PathVariable Integer projectId) {
        return projectService.getProjectById(projectId);
    }

    @PutMapping("/projects/{projectId}")
    public ProjectDto updateProject(@RequestBody Project project, @PathVariable Integer projectId) {
        return projectService.updateProject(project, projectId);
    }

}
