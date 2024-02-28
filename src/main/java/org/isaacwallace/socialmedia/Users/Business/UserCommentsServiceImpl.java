package org.isaacwallace.socialmedia.Users.Business;

import org.isaacwallace.socialmedia.Comments.DataAccess.Comment;
import org.isaacwallace.socialmedia.Comments.DataAccess.CommentRepository;
import org.isaacwallace.socialmedia.Comments.Mapper.CommentResponseMapper;
import org.isaacwallace.socialmedia.Comments.Presentation.Models.CommentResponseModel;
import org.isaacwallace.socialmedia.Users.DataAccess.User;
import org.isaacwallace.socialmedia.Users.DataAccess.UserRepository;
import org.isaacwallace.socialmedia.Users.Mapper.UserResponseMapper;
import org.isaacwallace.socialmedia.Users.Presentation.Models.UserCommentsResponseModel;
import org.isaacwallace.socialmedia.Utils.Exceptions.InvalidInputException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCommentsServiceImpl implements UserCommentsService {
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;
    private final UserResponseMapper userResponseMapper;
    private final CommentResponseMapper commentResponseMapper;

    public UserCommentsServiceImpl(UserRepository userRepository, CommentRepository commentRepository, UserResponseMapper userResponseMapper, CommentResponseMapper commentResponseMapper) {
        this.userRepository = userRepository;
        this.commentRepository = commentRepository;
        this.userResponseMapper = userResponseMapper;
        this.commentResponseMapper = commentResponseMapper;
    }

    public UserCommentsResponseModel getAllCommentsByUserId(String userid) {
        User user = this.userRepository.findUserByUserIdentifier_Userid(userid);

        if (user == null) {
            throw new InvalidInputException("Unknown userid: " + userid);
        }

        List<Comment> commentList = this.commentRepository.findCommentsByUserid(userid);
        List<CommentResponseModel> comments = this.commentResponseMapper.entitiesToResponseModelList(commentList);

        UserCommentsResponseModel userModel = this.userResponseMapper.commentToAggregateResponseModel(user);
        userModel.setComments(comments);

        return userModel;
    }
}