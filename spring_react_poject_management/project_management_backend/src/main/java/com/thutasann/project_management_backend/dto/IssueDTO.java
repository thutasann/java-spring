package com.thutasann.project_management_backend.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.thutasann.project_management_backend.models.Project;
import com.thutasann.project_management_backend.models.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Issue DTO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IssueDTO {
    private Long id;

    private String title;

    private String description;

    private String status;

    private Long projectID;

    private String priority;

    private LocalDate dueDate;

    private List<String> tags = new ArrayList<>();

    private Project project;

    private User assingnee;
}
