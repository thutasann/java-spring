package com.thutasann.project_management_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thutasann.project_management_backend.models.Issue;

public interface IssueRepository extends JpaRepository<Issue, Long> {
    List<Issue> findByprojectID(Long projectID);
}
