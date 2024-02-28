package org.isaacwallace.socialmedia.Posts.Business;

import org.isaacwallace.socialmedia.Comments.DataAccess.Comment;
import org.isaacwallace.socialmedia.Comments.DataAccess.CommentRepository;
import org.isaacwallace.socialmedia.Comments.Mapper.CommentResponseMapper;
import org.isaacwallace.socialmedia.Comments.Presentation.Models.CommentResponseModel;
import org.isaacwallace.socialmedia.Posts.DataAccess.Post;
import org.isaacwallace.socialmedia.Posts.DataAccess.PostRepository;
import org.isaacwallace.socialmedia.Posts.Mapper.PostResponseMapper;
import org.isaacwallace.socialmedia.Posts.Presentation.Models.PostCommentsResponseModel;
import org.isaacwallace.socialmedia.Utils.Exceptions.InvalidInputException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostCommentServiceImpl implements PostCommentService {
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final PostResponseMapper postResponseMapper;
    private final CommentResponseMapper commentResponseMapper;

    public PostCommentServiceImpl(PostRepository postRepository, CommentRepository commentRepository, PostResponseMapper postResponseMapper, CommentResponseMapper commentResponseMapper) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
        this.postResponseMapper = postResponseMapper;
        this.commentResponseMapper = commentResponseMapper;
    }

    public PostCommentsResponseModel getAllCommentsByPostId(String postid) {
        Post post = this.postRepository.findPostByPostIdentifier_Postid(postid);

        if (post == null) {
            throw new InvalidInputException("Unknown postid: " + postid);
        }

        List<Comment> commentList = this.commentRepository.findCommentsByPostid(postid);
        List<CommentResponseModel> comments = this.commentResponseMapper.entitiesToResponseModelList(commentList);

        PostCommentsResponseModel postModel = this.postResponseMapper.commentToAggregateResponseModel(post);
        postModel.setComments(comments);

        return postModel;
    }
}