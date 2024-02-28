package org.isaacwallace.socialmedia.Users.Business;

import org.isaacwallace.socialmedia.Users.Presentation.Models.UserPostsResponseModel;

public interface UserPostsService {
    public UserPostsResponseModel getAllPostsByUserId(String userid);
}
