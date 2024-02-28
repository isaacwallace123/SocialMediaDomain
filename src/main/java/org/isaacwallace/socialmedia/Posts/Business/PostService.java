package org.isaacwallace.socialmedia.Posts.Business;

import org.isaacwallace.socialmedia.Posts.Presentation.Models.PostRequestModel;
import org.isaacwallace.socialmedia.Posts.Presentation.Models.PostResponseModel;

import java.util.List;

public interface PostService {
    public List<PostResponseModel> getAllPosts();
    public PostResponseModel getPostById(String postid);
    public PostResponseModel addPost(PostRequestModel postRequestModel);
    public PostResponseModel editPost(String postid, PostRequestModel postRequestModel);
    public void deletePost(String postid);
}
