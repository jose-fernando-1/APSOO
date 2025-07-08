package com.apsoo.br.verificador_metricas.Repository;

import com.apsoo.br.verificador_metricas.Models.Project;

import java.util.HashMap;
import java.util.Map;

public class ProjectRepository {
    private static ProjectRepository instance;

    private Map<Long, Project> projects = new HashMap<>();
    private long currentId = 1;

    private ProjectRepository() {}

    public static ProjectRepository getInstance() {
        if (instance == null) {
            instance = new ProjectRepository();
        }
        return instance;
    }

    public synchronized Project addProject(Project project) {
        long id = currentId++;
        projects.put(id, project);
        return project;
    }

    public Project getProjectById(long id) {
        return projects.get(id);
    }

    public Map<Long, Project> getAllProjects() {
        return projects;
    }

    public boolean removeProject(long id) {
        return projects.remove(id) != null;
    }

    public boolean updateProject(long id, Project project) {
        if (projects.containsKey(id)) {
            projects.put(id, project);
            return true;
        }
        return false;
    }
}
