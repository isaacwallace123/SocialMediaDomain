package org.isaacwallace.socialmedia.Users.Business;

import org.isaacwallace.socialmedia.Users.Presentation.Models.UserPostsResponseModel;

public interface UserPostsService {
    UserPostsResponseModel getAllPostsByUserId(String userid);
}
