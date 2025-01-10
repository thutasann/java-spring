package com.thutasann.project_management_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thutasann.project_management_backend.models.Project;
import com.thutasann.project_management_backend.models.User;
import com.thutasann.project_management_backend.response.DataResponse;
import com.thutasann.project_management_backend.service.project.IProjectService;
import com.thutasann.project_management_backend.service.user.IUserService;

import static org.springframework.http.HttpStatus.NOT_FOUND;

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
        return ResponseEntity.ok(new DataResponse("success", projects));
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<DataResponse> getProjectById(
            @PathVariable Long projectId,
            @RequestHeader("Authorization") String jwt) throws Exception {
        try {
            Project project = projectService.getProjectById(projectId);
            return ResponseEntity.ok(new DataResponse("success", project));
        } catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND).body(new DataResponse(e.getMessage(), null));
        }
    }

}
