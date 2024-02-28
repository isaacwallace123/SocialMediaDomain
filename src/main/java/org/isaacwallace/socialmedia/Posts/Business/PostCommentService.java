package org.isaacwallace.socialmedia.Posts.Business;

import org.isaacwallace.socialmedia.Posts.Presentation.Models.PostCommentsResponseModel;

public interface PostCommentService {
    public PostCommentsResponseModel getAllCommentsByPostId(String postid);
}
