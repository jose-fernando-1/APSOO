package com.apsoo.br.verificador_metricas.Services;
import com.apsoo.br.verificador_metricas.Models.Project;
import com.apsoo.br.verificador_metricas.Models.User;
import com.apsoo.br.verificador_metricas.Repository.ProjectRepository;
import com.apsoo.br.verificador_metricas.Repository.UserRepository;

import java.util.Optional;

public class PlatformFacade {

    private static PlatformFacade instance;

    private final UserRepository userRepository = UserRepository.getInstance();
    private final ProjectRepository projectRepository = ProjectRepository.getInstance();

    private PlatformFacade() {}

    public static synchronized PlatformFacade getInstance() {
        if (instance == null) {
            instance = new PlatformFacade();
        }
        return instance;
    }

    // TODO:

    public boolean login(String email, String password){
        return userRepository.findByEmail(email)
                .map(user -> user.getPassword().equals(password))
                .orElse(false);
    }
    public Project addProject(Project project){
        return projectRepository.addProject(project);
    }

    public Project createProject(Project project){
        return projectRepository.addProject(project);
    }

    public Project findProjectById(long id){
        return projectRepository.getProjectById(id);
    }

    public Optional<User> findUserByEmail(String email){
        return userRepository.findByEmail(email);
    }

}
