package org.isaacwallace.socialmedia.Posts.Presentation;

import org.isaacwallace.socialmedia.Posts.Business.PostService;
import org.isaacwallace.socialmedia.Posts.Presentation.Models.PostResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/posts")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("")
    public ResponseEntity<List<PostResponseModel>> GetPosts() {
        return ResponseEntity.status(HttpStatus.OK).body(this.postService.getAllPosts());
    }

    @GetMapping("{postid}")
    public ResponseEntity<PostResponseModel> GetPost(@PathVariable String postid) {
        return ResponseEntity.status(HttpStatus.OK).body(this.postService.getPostById(postid));
    }
}
