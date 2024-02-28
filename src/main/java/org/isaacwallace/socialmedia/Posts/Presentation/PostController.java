package org.isaacwallace.socialmedia.Posts.Presentation;

import org.isaacwallace.socialmedia.Posts.Business.PostService;
import org.isaacwallace.socialmedia.Posts.Presentation.Models.PostRequestModel;
import org.isaacwallace.socialmedia.Posts.Presentation.Models.PostResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PostResponseModel> AddPost(@RequestBody PostRequestModel postRequestModel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.postService.addPost(postRequestModel));
    }

    @PutMapping(value = "{postid}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PostResponseModel> EditPost(@PathVariable String postid, @RequestBody PostRequestModel postRequestModel) {
        return ResponseEntity.status(HttpStatus.OK).body(this.postService.editPost(postid, postRequestModel));
    }

    @DeleteMapping(value = "{postid}")
    public ResponseEntity<Void> DeletePost(@PathVariable String postid) {
        this.postService.deletePost(postid);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
