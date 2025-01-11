package com.thutasann.project_management_backend.service.subscription;

import com.thutasann.project_management_backend.models.PlanType;
import com.thutasann.project_management_backend.models.Subscription;
import com.thutasann.project_management_backend.models.User;

public interface ISubscriptionService {
    Subscription createSubscription(User user);

    Subscription getUsersSubscription(Long userId) throws Exception;

    Subscription upgradeSubscription(Long userId, PlanType planType);

    boolean isValid(Subscription subscription);
}
