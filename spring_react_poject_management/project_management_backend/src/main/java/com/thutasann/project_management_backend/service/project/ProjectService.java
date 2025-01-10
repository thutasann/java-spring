package com.thutasann.project_management_backend.service.project;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thutasann.project_management_backend.models.Chat;
import com.thutasann.project_management_backend.models.Project;
import com.thutasann.project_management_backend.models.User;
import com.thutasann.project_management_backend.repository.ProjectRepository;
import com.thutasann.project_management_backend.service.chat.IChatService;
import com.thutasann.project_management_backend.service.user.UserService;

@Service
public class ProjectService implements IProjectService {

    @Autowired
    private ProjectRepository projectRepo;

    @Autowired
    private IChatService chatService;

    @Autowired
    private UserService userService;

    @Override
    public Project createProject(Project project, User user) throws Exception {
        Project createdProject = new Project();
        createdProject.setOwner(user);
        createdProject.setTags(project.getTags());
        createdProject.setName(project.getName());
        createdProject.setDescription(project.getDescription());
        createdProject.setCategory(project.getCategory());
        createdProject.getTeam().add(user);
        Project savedProject = projectRepo.save(createdProject);

        Chat chat = new Chat();
        chat.setProject(savedProject);
        Chat projectChat = chatService.createChat(chat);
        savedProject.setChat(projectChat);

        return savedProject;
    }

    @Override
    public List<Project> getProjectsByTeam(User user, String category, String tag) throws Exception {
        List<Project> projects = projectRepo.findByTeamContainingOrOwner(user, user);

        if (category != null) {
            projects = projects.stream().filter(project -> project.getCategory().equals(category))
                    .collect(Collectors.toList());
        }

        if (tag != null) {
            projects = projects.stream().filter(project -> project.getTags().contains(tag))
                    .collect(Collectors.toList());
        }

        return projects;
    }

    @Override
    public Project getProjectById(Long projectId) throws Exception {
        Optional<Project> optionalProject = projectRepo.findById(projectId);
        if (optionalProject.isEmpty()) {
            throw new Exception("project not found by Id");
        }
        return optionalProject.get();
    }

    @Override
    public void deleteProject(Long projectId, Long userId) throws Exception {
        this.getProjectById(projectId);
        userService.findUserById(userId);
    }

    @Override
    public Project updateProject(Project project, Long projectId) throws Exception {
        Project foundProject = getProjectById(projectId);
        foundProject.setName(project.getName());
        foundProject.setDescription(project.getDescription());
        foundProject.setTags(project.getTags());
        return projectRepo.save(project);
    }

    @Override
    public void addUserToProject(Long projectId, Long userId) throws Exception {
        Project project = getProjectById(projectId);
        User user = userService.findUserById(userId);
        if (!project.getTeam().contains(user)) {
            project.getChat().getUsers().add(user);
            project.getTeam().add(user);
        }
        projectRepo.save(project);
    }

    @Override
    public void removeUserFromProject(Long projectId, Long userId) throws Exception {
        Project project = getProjectById(projectId);
        User user = userService.findUserById(userId);
        if (!project.getTeam().contains(user)) {
            project.getChat().getUsers().remove(user);
            project.getTeam().remove(user);
        }
        projectRepo.save(project);
    }

    @Override
    public Chat getChatByProjectId(Long projectId) throws Exception {
        Project project = getProjectById(projectId);
        return project.getChat();
    }

    @Override
    public List<Project> searchProjects(String keyword, User user) throws Exception {
        String partialName = "%" + keyword + "%";
        List<Project> projects = projectRepo.findByNameContainingAndTeamContains(partialName, user);
        return projects;
    }

}
