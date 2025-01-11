package com.thutasann.project_management_backend.controller;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thutasann.project_management_backend.dto.IssueDTO;
import com.thutasann.project_management_backend.models.Issue;
import com.thutasann.project_management_backend.models.User;
import com.thutasann.project_management_backend.request.IssueRequest;
import com.thutasann.project_management_backend.response.DataResponse;
import com.thutasann.project_management_backend.service.issue.IIssueService;
import com.thutasann.project_management_backend.service.user.IUserService;

import lombok.RequiredArgsConstructor;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/issues")
@SecurityRequirement(name = "BearerAuth")
public class IssueController {
    @Autowired
    private IIssueService issueService;

    @Autowired
    private IUserService userService;

    @GetMapping("/get/{issueId}")
    public ResponseEntity<DataResponse> getIssueById(
            @PathVariable() Long issueId,
            @RequestHeader("Authorization") String jwt) throws Exception {

        try {
            Issue issue = issueService.getIssueById(issueId);
            return ResponseEntity.ok(new DataResponse("get issue by Id success", issue));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new DataResponse(e.getMessage(), null));
        }
    }

    @PostMapping("/create")
    public ResponseEntity<DataResponse> createIssue(
            @RequestBody IssueRequest issueRequest,
            @RequestHeader("Authorization") String jwt) throws Exception {
        try {
            User tokenUser = userService.findUserProfileByJwt(jwt);
            User user = userService.findUserById(tokenUser.getId());

            if (user != null) {
                Issue createdIssue = issueService.createIssue(issueRequest, tokenUser);
                IssueDTO issueDTO = new IssueDTO();
                issueDTO.setDescription(createdIssue.getDescription());
                issueDTO.setDueDate(createdIssue.getDueDate());
                issueDTO.setId(createdIssue.getId());
                issueDTO.setPriority(createdIssue.getPriority());
                issueDTO.setProject(createdIssue.getProject());
                issueDTO.setProjectID(createdIssue.getProjectID());
                issueDTO.setStatus(createdIssue.getStatus());
                issueDTO.setTitle(createdIssue.getTitle());
                issueDTO.setTags(createdIssue.getTags());
                issueDTO.setAssingnee(createdIssue.getAssignee());
                return ResponseEntity.ok(new DataResponse("issue created", issueDTO));
            } else {
                return ResponseEntity.status(UNAUTHORIZED).body(new DataResponse("Unauthorized", null));
            }
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new DataResponse(e.getMessage(), null));
        }
    }

    @DeleteMapping("/delete/{issueId}")
    public ResponseEntity<DataResponse> deleteIssue(
            @PathVariable Long issueId,
            @RequestHeader("Authorization") String jwt) throws Exception {
        try {
            User user = userService.findUserProfileByJwt(jwt);
            issueService.deleteIssue(issueId, user.getId());
            return ResponseEntity.ok(new DataResponse("issue deleted", null));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new DataResponse(e.getMessage(), null));
        }
    }

    @PutMapping("/add-user-to-issue/{issueId}/{userId}")
    public ResponseEntity<DataResponse> addUserToIssue(
            @PathVariable Long issueId,
            @PathVariable Long userId,
            @RequestHeader("Authorization") String jwt) throws Exception {
        try {
            Issue issue = issueService.addUserToIssue(issueId, userId);
            return ResponseEntity.ok(new DataResponse("added user to issue success", issue));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new DataResponse(e.getMessage(), null));
        }
    }

    @PutMapping("/update-status/{issueId}")
    public ResponseEntity<DataResponse> updateStatus(
            @PathVariable Long issueId,
            @RequestParam String status,
            @RequestHeader("Authorization") String jwt) throws Exception {
        try {
            Issue issue = issueService.updateStatus(issueId, status);
            return ResponseEntity.ok(new DataResponse("update status to issue success", issue));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new DataResponse(e.getMessage(), null));
        }
    }
}
