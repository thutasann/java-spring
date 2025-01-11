package com.thutasann.project_management_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thutasann.project_management_backend.models.Chat;
import com.thutasann.project_management_backend.models.Project;
import com.thutasann.project_management_backend.models.User;
import com.thutasann.project_management_backend.response.DataResponse;
import com.thutasann.project_management_backend.service.project.IProjectService;
import com.thutasann.project_management_backend.service.user.IUserService;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/projects")
@SecurityRequirement(name = "BearerAuth")
public class ProjectController {
    @Autowired
    private IProjectService projectService;

    @Autowired
    private IUserService userService;

    @GetMapping("/get")
    public ResponseEntity<DataResponse> getProjects(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String tags,
            @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserProfileByJwt(jwt);
        List<Project> projects = projectService.getProjectsByTeam(user, category, tags);
        return ResponseEntity.ok(new DataResponse("get projects success", projects));
    }

    @GetMapping("/search")
    public ResponseEntity<DataResponse> searchProjects(
            @RequestParam(required = false) String keyword,
            @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserProfileByJwt(jwt);
        List<Project> projects = projectService.searchProjects(keyword, user);
        return ResponseEntity.ok(new DataResponse("search projects success", projects));
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<DataResponse> getProjectById(
            @PathVariable Long projectId,
            @RequestHeader("Authorization") String jwt) throws Exception {
        try {
            Project project = projectService.getProjectById(projectId);
            return ResponseEntity.ok(new DataResponse("get project by Id success", project));
        } catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND).body(new DataResponse(e.getMessage(), null));
        }
    }

    @GetMapping("/get-chat/{projectId}")
    public ResponseEntity<DataResponse> getChatByProjectId(
            @PathVariable Long projectId,
            @RequestHeader("Authorization") String jwt) throws Exception {
        try {
            Chat chat = projectService.getChatByProjectId(projectId);
            return ResponseEntity.ok(new DataResponse("get chat by project Id success", chat));
        } catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND).body(new DataResponse(e.getMessage(), null));
        }
    }

    @PostMapping("/create")
    public ResponseEntity<DataResponse> createProject(
            @RequestHeader("Authorization") String jwt,
            @RequestBody Project project) {
        try {
            User user = userService.findUserProfileByJwt(jwt);
            Project createdProject = projectService.createProject(project, user);
            return ResponseEntity.ok(new DataResponse("create success", createdProject));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new DataResponse(e.getMessage(), null));
        }
    }

    @PatchMapping("/update/{projectId}")
    public ResponseEntity<DataResponse> updateProject(
            @RequestHeader("Authorization") String jwt,
            @RequestBody Project project,
            @PathVariable Long projectId) {
        try {
            Project updatedProject = projectService.updateProject(project, projectId);
            return ResponseEntity.ok(new DataResponse("update success", updatedProject));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new DataResponse(e.getMessage(), null));
        }
    }

    @DeleteMapping("/delete/{projectId}")
    public ResponseEntity<DataResponse> deleteProject(
            @RequestHeader("Authorization") String jwt,
            @PathVariable Long projectId) {
        try {
            User user = userService.findUserProfileByJwt(jwt);
            projectService.deleteProject(projectId, user.getId());
            return ResponseEntity.ok(new DataResponse("delete success", null));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new DataResponse(e.getMessage(), null));
        }
    }

}
