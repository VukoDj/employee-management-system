package com.spring.testproject.ems.employeemanagementsystem.entities.project.service;

import com.spring.testproject.ems.employeemanagementsystem.entities.department.mapper.DepartmentMapper;
import com.spring.testproject.ems.employeemanagementsystem.entities.department.model.Department;
import com.spring.testproject.ems.employeemanagementsystem.entities.project.dto.ProjectDto;
import com.spring.testproject.ems.employeemanagementsystem.entities.project.mapper.ProjectMapper;
import com.spring.testproject.ems.employeemanagementsystem.entities.project.model.Project;
import com.spring.testproject.ems.employeemanagementsystem.entities.project.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService{

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public ProjectDto addProject(Project project) {
//        Project newProject = projectRepository.save(project);
        return ProjectMapper.toProjectDto(projectRepository.save(project));
    }

    @Override
    public List<ProjectDto> getAllProjects(String searchExpression) {
        List<Project> projects;
        if(searchExpression != null){
            projects =projectRepository.search(searchExpression);
        }else{
            projects = projectRepository.findAll();
        }

        if(!projects.isEmpty()){
            return projects
                    .stream()
                    .map(ProjectMapper::toProjectDto)
                    .collect(Collectors.toList());
        }else{
            return Collections.emptyList();
        }    }

    @Override
    public ProjectDto getProjectById(Integer projectId) {
        Optional<Project> project = projectRepository.findById(projectId);
        return project.map(ProjectMapper::toProjectDto).orElse(null);    }

    @Override
    public ProjectDto updateDepartment(Project project, Integer projectId) {
        Project old_project = projectRepository.findById(projectId).get();
        project.setId(projectId);
        return ProjectMapper.toProjectDto(projectRepository.save(project));    }
}
