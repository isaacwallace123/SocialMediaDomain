package org.isaacwallace.socialmedia.Users.Presentation.Models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.isaacwallace.socialmedia.Common.Objects.Address;
import org.isaacwallace.socialmedia.Posts.Presentation.Models.PostResponseModel;

import java.util.Date;
import java.util.List;

@Data
public class UserPostsResponseModel {
    private String userid;

    private String first_name;
    private String last_name;

    private String username;
    private String email;

    private String bio;
    private Date joined_date;

    private Address address;

    private List<PostResponseModel> Posts;
}
