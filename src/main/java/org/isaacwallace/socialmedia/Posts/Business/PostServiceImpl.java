package org.isaacwallace.socialmedia.Posts.Business;

import org.isaacwallace.socialmedia.Posts.DataAccess.Post;
import org.isaacwallace.socialmedia.Posts.DataAccess.PostRepository;
import org.isaacwallace.socialmedia.Posts.Mapper.PostRequestMapper;
import org.isaacwallace.socialmedia.Posts.Mapper.PostResponseMapper;
import org.isaacwallace.socialmedia.Posts.Presentation.Models.PostResponseModel;
import org.isaacwallace.socialmedia.Utils.Exceptions.InvalidInputException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final PostResponseMapper postResponseMapper;
    private final PostRequestMapper postRequestMapper;

    public PostServiceImpl(PostRepository postRepository, PostResponseMapper postResponseMapper, PostRequestMapper postRequestMapper) {
        this.postRepository = postRepository;
        this.postResponseMapper = postResponseMapper;
        this.postRequestMapper = postRequestMapper;
    }

    public List<PostResponseModel> getAllPosts() {
        return this.postResponseMapper.entityListToResponseModelList(this.postRepository.findAll());
    }
    public PostResponseModel getPostById(String postid) {
        Post post = this.postRepository.findPostByPostIdentifier_Postid(postid);

        if (post == null) {
            throw new InvalidInputException("Unknown userId: " + postid);
        }

        return this.postResponseMapper.entityToResponseModel(post);
    }
}
