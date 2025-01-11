package com.thutasann.project_management_backend.service.comment;

import java.util.List;

import com.thutasann.project_management_backend.models.Comment;

public interface ICommentService {
    Comment createComment(Long issueId, Long userId, String content) throws Exception;

    void deleteComment(Long commentId, Long userId) throws Exception;

    List<Comment> findCommentByIssueId(Long issueId);
}
