package com.thutasann.project_management_backend.service.issue;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thutasann.project_management_backend.models.Issue;
import com.thutasann.project_management_backend.models.Project;
import com.thutasann.project_management_backend.models.User;
import com.thutasann.project_management_backend.repository.IssueRepository;
import com.thutasann.project_management_backend.request.IssueRequest;
import com.thutasann.project_management_backend.service.project.IProjectService;
import com.thutasann.project_management_backend.service.user.IUserService;
import com.thutasann.project_management_backend.utilities.CustomLogger;

@Service
public class IssueService implements IIssueService {

    @Autowired
    private IssueRepository issueRepo;

    @Autowired
    private IProjectService projectService;

    @Autowired
    private IUserService userService;

    @Autowired
    private CustomLogger logger;

    @Override
    public Issue getIssueById(Long issueId) throws Exception {
        Optional<Issue> issue = issueRepo.findById(issueId);
        if (issue.isPresent()) {
            return issue.get();
        }
        logger.logInfo("Issue not found with Id: " + issueId);
        throw new Exception("Issue not found with Id: " + issueId);
    }

    @Override
    public List<Issue> getIssuesByProjectId(Long projectId) throws Exception {
        if (projectId == null) {
            throw new Exception("Project ID is needed to proceed this API");
        }
        return issueRepo.findByprojectID(projectId);
    }

    @Override
    public Issue createIssue(IssueRequest request, User user) throws Exception {
        Project project = projectService.getProjectById(request.getProjectID());

        Issue issue = new Issue();
        issue.setTitle(request.getTitle());
        issue.setDescription(request.getDescription());
        issue.setStatus(request.getStatus());
        issue.setProjectID(request.getProjectID());
        issue.setPriority(request.getPriority());
        issue.setDueDate(request.getDueDate());
        issue.setProject(project);

        return issueRepo.save(issue);
    }

    @Override
    public Optional<Issue> updateIssue(Long issueId, IssueRequest updatedIssue, Long userId) throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'updateIssue'");
    }

    @Override
    public void deleteIssue(Long issueId, Long userId) throws Exception {
        this.getIssueById(issueId);
        issueRepo.deleteById(issueId);
    }

    @Override
    public Issue addUserToIssue(Long issueId, Long userId) throws Exception {
        User user = userService.findUserById(userId);
        Issue issue = this.getIssueById(issueId);
        issue.setAssignee(user);

        return issueRepo.save(issue);
    }

    @Override
    public Issue updateStatus(Long issueId, String status) throws Exception {
        Issue issue = this.getIssueById(issueId);
        issue.setStatus(status);
        return issueRepo.save(issue);
    }
}
