package org.isaacwallace.socialmedia.Users.Presentation;

import org.isaacwallace.socialmedia.Users.Business.UserPostsService;
import org.isaacwallace.socialmedia.Users.Presentation.Models.UserPostsResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users/{userid}/posts")
public class UserPostsController {
    private final UserPostsService userPostsService;

    public UserPostsController(UserPostsService userPostsService) {
        this.userPostsService = userPostsService;
    }

    @GetMapping("")
    public ResponseEntity<UserPostsResponseModel> GetPosts(@PathVariable String userid) {
        return ResponseEntity.status(HttpStatus.OK).body(this.userPostsService.getAllPostsByUserId(userid));
    }
}
