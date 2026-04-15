package com.example.demo;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/projects")
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    @PostMapping()
    public void addProject(@RequestBody Project project) {
        projectService.addProject(project);
    }

    @DeleteMapping("{id}")
    public void deleteProject(@PathVariable("id") Integer id) {
        projectService.deleteProject(id);
    }

    @PutMapping("{id}")
    public void updateProject(@PathVariable("id") Integer id, @RequestBody Project project) {
        projectService.updateProject(id, project);
    }

    @GetMapping("{id}")
    public Project getProject(@PathVariable("id") Integer id) {
        return projectService.getProject(id);
    }
}
