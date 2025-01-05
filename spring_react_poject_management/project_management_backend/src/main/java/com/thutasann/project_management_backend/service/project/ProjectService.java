package com.thutasann.project_management_backend.service.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thutasann.project_management_backend.models.Chat;
import com.thutasann.project_management_backend.models.Project;
import com.thutasann.project_management_backend.models.User;
import com.thutasann.project_management_backend.repository.ProjectRepository;

@Service
public class ProjectService implements IProjectService {

    @Autowired
    private ProjectRepository projectRepo;

    @Override
    public Project createProject(Project project, User user) throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'createProject'");
    }

    @Override
    public List<Project> getProjectsByTeam(User user, String category, String tag) throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'getProjectsByTeam'");
    }

    @Override
    public Project getProjectById(Long projectId) throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'getProjectById'");
    }

    @Override
    public void deleteProject(Long projectId, Long userId) throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'deleteProject'");
    }

    @Override
    public Project updateProject(Project project, Long projectId) throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'updateProject'");
    }

    @Override
    public void addUserToProject(Long projectId, Long userId) throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'addUserToProject'");
    }

    @Override
    public void removeUserFromProject(Long projectId, Long userId) throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'removeUserFromProject'");
    }

    @Override
    public Chat getChatByProjectId(Long projectId) throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'getChatByProjectId'");
    }

}
