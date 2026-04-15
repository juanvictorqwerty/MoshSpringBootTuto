package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    private final ProjectRepo projectRepo;

    public ProjectService(ProjectRepo projectRepo) {
        this.projectRepo = projectRepo;
    }

    public List<Project> getAllProjects() {
        return projectRepo.findAll();
    }

    public void addProject(Project project) {
        projectRepo.save(project);
    }

    public void deleteProject(Integer id) {
        projectRepo.deleteById(id);
    }

    public void updateProject(Integer id, Project project) {
        projectRepo.save(project);
    }

    public Project getProject(Integer id) {
        return projectRepo.findById(id).get();
    }
}
