package com.thutasann.project_management_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thutasann.project_management_backend.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
