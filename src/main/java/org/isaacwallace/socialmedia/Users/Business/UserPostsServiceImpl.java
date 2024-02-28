package org.isaacwallace.socialmedia.Users.Business;

import org.isaacwallace.socialmedia.Posts.DataAccess.Post;
import org.isaacwallace.socialmedia.Posts.DataAccess.PostRepository;
import org.isaacwallace.socialmedia.Posts.Mapper.PostResponseMapper;
import org.isaacwallace.socialmedia.Posts.Presentation.Models.PostResponseModel;
import org.isaacwallace.socialmedia.Users.DataAccess.User;
import org.isaacwallace.socialmedia.Users.DataAccess.UserRepository;
import org.isaacwallace.socialmedia.Users.Mapper.UserResponseMapper;
import org.isaacwallace.socialmedia.Users.Presentation.Models.UserPostsResponseModel;
import org.isaacwallace.socialmedia.Utils.Exceptions.InvalidInputException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPostsServiceImpl implements UserPostsService {
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final UserResponseMapper userResponseMapper;
    private final PostResponseMapper postResponseMapper;

    public UserPostsServiceImpl(UserRepository userRepository, PostRepository postRepository, UserResponseMapper userResponseMapper, PostResponseMapper postResponseMapper) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
        this.userResponseMapper = userResponseMapper;
        this.postResponseMapper = postResponseMapper;
    }

    public UserPostsResponseModel getAllPostsByUserId(String userid) {
        User user = this.userRepository.findUserByUserIdentifier_Userid(userid);

        if (user == null) {
            throw new InvalidInputException("Unknown userid: " + userid);
        }

        List<Post> postList = this.postRepository.findPostsByUserid(userid);
        List<PostResponseModel> posts = this.postResponseMapper.entitiesToResponseModelList(postList);

        UserPostsResponseModel userModel = this.userResponseMapper.entityToAggregateResponseModel(user);
        userModel.setPosts(posts);

        return userModel;
    }
}
