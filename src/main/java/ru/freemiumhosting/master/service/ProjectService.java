package ru.freemiumhosting.master.service;

import org.springframework.stereotype.Service;
import ru.freemiumhosting.master.model.Project;

import java.util.List;

public interface ProjectService {
    void createProject(Project project);
    void deployProject(Project project);
    Project getProjectDetails(Long projectId);
    List<Project> getAllProjects(Long projectId);
}
