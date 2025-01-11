package com.thutasann.project_management_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thutasann.project_management_backend.models.Subscription;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    Subscription findByUserId(Long userId);
}
