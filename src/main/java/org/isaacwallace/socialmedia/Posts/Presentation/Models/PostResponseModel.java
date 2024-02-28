package org.isaacwallace.socialmedia.Posts.Presentation.Models;

import lombok.Data;
import org.isaacwallace.socialmedia.Posts.DataAccess.Media;
import org.springframework.hateoas.RepresentationModel;

import java.util.Date;

@Data
public class PostResponseModel extends RepresentationModel<PostResponseModel> {
    private String postid;
    private String userid;
    private String content;
    private Date created_date;
    private Media media;
}
