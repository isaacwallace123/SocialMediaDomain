package org.isaacwallace.socialmedia.Comments.Presentation;

import org.isaacwallace.socialmedia.Comments.Business.CommentService;
import org.isaacwallace.socialmedia.Comments.Presentation.Models.CommentRequestModel;
import org.isaacwallace.socialmedia.Comments.Presentation.Models.CommentResponseModel;
import org.isaacwallace.socialmedia.Posts.Presentation.Models.PostRequestModel;
import org.isaacwallace.socialmedia.Posts.Presentation.Models.PostResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/comments")
public class CommentsController {
    private final CommentService commentService;

    public CommentsController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("")
    public ResponseEntity<List<CommentResponseModel>> GetComments() {
        return ResponseEntity.status(HttpStatus.OK).body(this.commentService.getAllComments());
    }

    @GetMapping("{commentid}")
    public ResponseEntity<CommentResponseModel> GetComment(@PathVariable String commentid) {
        return ResponseEntity.status(HttpStatus.OK).body(this.commentService.getCommentById(commentid));
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommentResponseModel> AddComment(@RequestBody CommentRequestModel commentRequestModel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.commentService.addComment(commentRequestModel));
    }

    @PutMapping(value = "{commentid}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommentResponseModel> EditComment(@PathVariable String commentid, @RequestBody CommentRequestModel commentRequestModel) {
        return ResponseEntity.status(HttpStatus.OK).body(this.commentService.editComment(commentid, commentRequestModel));
    }

    @DeleteMapping(value = "{commentid}")
    public ResponseEntity<Void> DeleteComment(@PathVariable String commentid) {
        this.commentService.deleteComment(commentid);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
