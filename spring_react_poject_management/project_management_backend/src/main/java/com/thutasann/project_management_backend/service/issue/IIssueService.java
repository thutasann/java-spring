package com.thutasann.project_management_backend.service.issue;

import java.util.List;
import java.util.Optional;

import com.thutasann.project_management_backend.models.Issue;
import com.thutasann.project_management_backend.models.User;
import com.thutasann.project_management_backend.request.IssueRequest;

public interface IIssueService {
    Issue getIssueById(Long issueId) throws Exception;

    List<Issue> getIssuesByProjectId(Long projectId) throws Exception;

    Issue createIssue(IssueRequest request, User user) throws Exception;

    Optional<Issue> updateIssue(Long issueId, IssueRequest updatedIssue, Long userId) throws Exception;

    void deleteIssue(Long issueId, Long userId) throws Exception;

    // List<Issue> getIssuesyAssigneeId(Long assigneeId) throws Exception;

    // List<Issue> searchIssues(String title, String status, String priority, Long
    // assigneeId) throws Exception;

    // List<User> getAsigneeForIssue(Long issueId) throws Exception;

    Issue addUserToIssue(Long issueId, Long userId) throws Exception;

    Issue updateStatus(Long issueId, String status) throws Exception;
}
