package com.thutasann.project_management_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thutasann.project_management_backend.models.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByIssueId(Long issueId);
}
