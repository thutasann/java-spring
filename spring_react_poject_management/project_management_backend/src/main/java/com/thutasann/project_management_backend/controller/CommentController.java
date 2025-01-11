package com.thutasann.project_management_backend.controller;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thutasann.project_management_backend.models.Comment;
import com.thutasann.project_management_backend.models.User;
import com.thutasann.project_management_backend.request.CreateCommentRequest;
import com.thutasann.project_management_backend.response.DataResponse;
import com.thutasann.project_management_backend.service.comment.ICommentService;
import com.thutasann.project_management_backend.service.user.IUserService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/comments")
@SecurityRequirement(name = "BearerAuth")
public class CommentController {
    @Autowired
    private ICommentService commentService;

    @Autowired
    private IUserService userService;

    @PostMapping("/create")
    public ResponseEntity<DataResponse> createComment(
            @RequestBody CreateCommentRequest request,
            @RequestHeader("Authorization") String jwt) throws Exception {
        try {
            User tokenUser = userService.findUserProfileByJwt(jwt);
            Comment comment = commentService.createComment(request.getIssueId(),
                    tokenUser.getId(),
                    request.getContent());
            return ResponseEntity.ok(new DataResponse("comment created", comment));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new DataResponse(e.getMessage(), null));
        }
    }

    @DeleteMapping("/delete/{commentId}")
    public ResponseEntity<DataResponse> deleteComment(
            @PathVariable Long commentId,
            @RequestHeader("Authorization") String jwt) throws Exception {
        try {
            User tokenUser = userService.findUserProfileByJwt(jwt);
            commentService.deleteComment(commentId, tokenUser.getId());
            return ResponseEntity.ok(new DataResponse("comment deleted", null));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new DataResponse(e.getMessage(), null));
        }
    }

    @GetMapping("/get/issue/{issueId}")
    public ResponseEntity<DataResponse> getCommentsByIssueId(
            @PathVariable Long issueId,
            @RequestHeader("Authorization") String jwt) throws Exception {
        try {
            List<Comment> comments = commentService.findCommentByIssueId(issueId);
            return ResponseEntity.ok(new DataResponse("get comments by Issue Id", comments));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new DataResponse(e.getMessage(), null));
        }
    }
}
