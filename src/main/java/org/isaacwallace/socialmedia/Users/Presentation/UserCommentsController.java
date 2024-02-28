package org.isaacwallace.socialmedia.Users.Presentation;

import org.isaacwallace.socialmedia.Users.Business.UserCommentsService;
import org.isaacwallace.socialmedia.Users.Presentation.Models.UserCommentsResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users/{userid}/comments")
public class UserCommentsController {
    private final UserCommentsService userCommentsService;

    public UserCommentsController(UserCommentsService userCommentsService) {
        this.userCommentsService = userCommentsService;
    }

    @GetMapping("")
    public ResponseEntity<UserCommentsResponseModel> GetComments(@PathVariable String userid) {
        return ResponseEntity.status(HttpStatus.OK).body(this.userCommentsService.getAllCommentsByUserId(userid));
    }
}