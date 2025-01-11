package com.thutasann.project_management_backend.service.comment;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thutasann.project_management_backend.models.Comment;
import com.thutasann.project_management_backend.models.Issue;
import com.thutasann.project_management_backend.models.User;
import com.thutasann.project_management_backend.repository.CommentRepository;
import com.thutasann.project_management_backend.repository.IssueRepository;
import com.thutasann.project_management_backend.repository.UserRepository;

@Service
public class CommentService implements ICommentService {

    @Autowired
    private CommentRepository commentRepo;

    @Autowired
    private IssueRepository issueRepo;

    @Autowired
    private UserRepository userRepo;

    @Override
    public Comment createComment(Long issueId, Long userId, String content) throws Exception {
        Optional<Issue> issueOptional = issueRepo.findById(issueId);
        Optional<User> userOptional = userRepo.findById(userId);

        if (issueOptional.isEmpty()) {
            throw new Exception("Issue not found with Id : " + issueId);
        }

        if (userOptional.isEmpty()) {
            throw new Exception("User not found with Id: " + userId);
        }

        Issue issue = issueOptional.get();
        User user = userOptional.get();

        Comment comment = new Comment();
        comment.setIssue(issue);
        comment.setUser(user);
        comment.setCreatedDateTime(LocalDateTime.now());
        comment.setContent(content);

        Comment savedComment = commentRepo.save(comment);

        issue.getComments().add(savedComment);

        return savedComment;
    }

    @Override
    public void deleteComment(Long commentId, Long userId) throws Exception {
        Optional<Comment> commentOptional = commentRepo.findById(commentId);
        Optional<User> userOptional = userRepo.findById(userId);

        if (commentOptional.isEmpty()) {
            throw new Exception("Comment not found with Id : " + commentId);
        }

        if (userOptional.isEmpty()) {
            throw new Exception("User not found with Id: " + userId);
        }

        Comment comment = commentOptional.get();
        User user = userOptional.get();

        if (comment.getUser().equals(user)) {
            commentRepo.delete(comment);
        } else {
            throw new Exception("User does not have permission to delete this comment!");
        }

    }

    @Override
    public List<Comment> findCommentByIssueId(Long issueId) {
        return commentRepo.findByIssueId(issueId);
    }

}
