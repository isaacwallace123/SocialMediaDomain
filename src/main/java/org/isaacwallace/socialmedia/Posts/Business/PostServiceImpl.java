package org.isaacwallace.socialmedia.Posts.Business;

import org.isaacwallace.socialmedia.Posts.DataAccess.Post;
import org.isaacwallace.socialmedia.Posts.DataAccess.PostIdentifier;
import org.isaacwallace.socialmedia.Posts.DataAccess.PostRepository;
import org.isaacwallace.socialmedia.Posts.Mapper.PostRequestMapper;
import org.isaacwallace.socialmedia.Posts.Mapper.PostResponseMapper;
import org.isaacwallace.socialmedia.Posts.Presentation.Models.PostRequestModel;
import org.isaacwallace.socialmedia.Posts.Presentation.Models.PostResponseModel;
import org.isaacwallace.socialmedia.Utils.Exceptions.InUseException;
import org.isaacwallace.socialmedia.Utils.Exceptions.InvalidInputException;
import org.springframework.dao.DataIntegrityViolationException;
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

    public PostResponseModel addPost(PostRequestModel postRequestModel) {
        Post newPost = this.postRequestMapper.requestModelToEntity(postRequestModel, new PostIdentifier());

        return this.postResponseMapper.entityToResponseModel(newPost);
    }

    public PostResponseModel editPost(String postid, PostRequestModel postRequestModel) {
        Post post = this.postRepository.findPostByPostIdentifier_Postid(postid);

        if (post == null) {
            throw new InvalidInputException("Unknown postid: " + postid);
        }

        Post updatedPost = this.postRequestMapper.requestModelToEntity(postRequestModel, post.getPostIdentifier());

        this.postRepository.save(updatedPost);

        return this.postResponseMapper.entityToResponseModel(updatedPost);
    }

    public void deletePost(String postid) {
        Post post = this.postRepository.findPostByPostIdentifier_Postid(postid);

        if (post == null) {
            throw new InvalidInputException("Unknown postid: " + postid);
        }

        try {
            this.postRepository.delete(post);
        } catch(DataIntegrityViolationException exception) {
            throw new InUseException("Post is in use by another entity, currently cannot delete.");
        }
    }
}
