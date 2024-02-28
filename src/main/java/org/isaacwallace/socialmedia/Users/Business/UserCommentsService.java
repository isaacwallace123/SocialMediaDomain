package org.isaacwallace.socialmedia.Users.Business;

import org.isaacwallace.socialmedia.Users.Presentation.Models.UserCommentsResponseModel;
import org.isaacwallace.socialmedia.Users.Presentation.Models.UserPostsResponseModel;

public interface UserCommentsService {
    public UserCommentsResponseModel getAllCommentsByUserId(String userid);
}
