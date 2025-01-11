package com.thutasann.project_management_backend.controller;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thutasann.project_management_backend.models.PlanType;
import com.thutasann.project_management_backend.models.Subscription;
import com.thutasann.project_management_backend.models.User;
import com.thutasann.project_management_backend.response.DataResponse;
import com.thutasann.project_management_backend.service.subscription.ISubscriptionService;
import com.thutasann.project_management_backend.service.user.IUserService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/subscriptions")
@SecurityRequirement(name = "BearerAuth")
public class SubscriptionController {

    @Autowired
    private ISubscriptionService subscriptionService;

    @Autowired
    private IUserService userService;

    @PostMapping("/create")
    public ResponseEntity<DataResponse> createSubscription(
            @RequestHeader("Authorization") String jwt) throws Exception {
        try {
            User tokenUser = userService.findUserProfileByJwt(jwt);
            User user = userService.findUserById(tokenUser.getId());

            if (user != null) {
                Subscription subscription = subscriptionService.createSubscription(user);
                return ResponseEntity.ok(new DataResponse("subscription created", subscription));
            } else {
                return ResponseEntity.status(UNAUTHORIZED).body(new DataResponse("Unauthorized", null));
            }
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new DataResponse(e.getMessage(), null));
        }
    }

    @GetMapping("/get")
    public ResponseEntity<DataResponse> getUsersSubscription(
            @RequestHeader("Authorization") String jwt) throws Exception {
        try {
            User tokenUser = userService.findUserProfileByJwt(jwt);

            if (tokenUser != null) {
                Subscription subscription = subscriptionService.getUsersSubscription(tokenUser.getId());
                return ResponseEntity.ok(new DataResponse("subscription by user id", subscription));
            } else {
                return ResponseEntity.status(UNAUTHORIZED).body(new DataResponse("Unauthorized", null));
            }
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new DataResponse(e.getMessage(), null));
        }
    }

    @PutMapping("/upgrade")
    public ResponseEntity<DataResponse> upgradeSubscription(
            @RequestParam PlanType planType,
            @RequestHeader("Authorization") String jwt) throws Exception {
        try {
            User tokenUser = userService.findUserProfileByJwt(jwt);

            if (tokenUser != null) {
                Subscription subscription = subscriptionService.upgradeSubscription(tokenUser.getId(), planType);
                return ResponseEntity.ok(new DataResponse("upgrade subscription", subscription));
            } else {
                return ResponseEntity.status(UNAUTHORIZED).body(new DataResponse("Unauthorized", null));
            }
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new DataResponse(e.getMessage(), null));
        }
    }
}
