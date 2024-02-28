package org.isaacwallace.socialmedia.Posts.Presentation;

import org.isaacwallace.socialmedia.Posts.Business.PostCommentService;
import org.isaacwallace.socialmedia.Posts.Presentation.Models.PostCommentsResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/posts/{postid}/comments")
public class PostCommentsController {
    private final PostCommentService postCommentService;

    public PostCommentsController(PostCommentService postCommentService) {
        this.postCommentService = postCommentService;
    }

    @GetMapping("")
    public ResponseEntity<PostCommentsResponseModel> GetComments(@PathVariable String postid) {
        return ResponseEntity.status(HttpStatus.OK).body(this.postCommentService.getAllCommentsByPostId(postid));
    }
}