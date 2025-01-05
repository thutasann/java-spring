package com.thutasann.project_management_backend.service.project;

import java.util.List;

import com.thutasann.project_management_backend.models.Chat;
import com.thutasann.project_management_backend.models.Project;
import com.thutasann.project_management_backend.models.User;

public interface IProjectService {
    Project createProject(Project project, User user) throws Exception;

    List<Project> getProjectsByTeam(User user, String category, String tag) throws Exception;

    Project getProjectById(Long projectId) throws Exception;

    void deleteProject(Long projectId, Long userId) throws Exception;

    Project updateProject(Project project, Long projectId) throws Exception;

    void addUserToProject(Long projectId, Long userId) throws Exception;

    void removeUserFromProject(Long projectId, Long userId) throws Exception;

    Chat getChatByProjectId(Long projectId) throws Exception;

    List<Project> searchProjects(String keyword, User user) throws Exception;
}
