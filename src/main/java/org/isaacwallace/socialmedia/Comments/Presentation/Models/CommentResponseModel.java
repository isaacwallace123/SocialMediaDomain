package org.isaacwallace.socialmedia.Comments.Presentation.Models;

import lombok.Data;
import org.isaacwallace.socialmedia.Posts.Presentation.Models.PostResponseModel;
import org.springframework.hateoas.RepresentationModel;

import java.util.Date;

@Data
public class CommentResponseModel extends RepresentationModel<PostResponseModel> {
    private String commentid;
    private String postid;
    private String userid;
    private String content;
    private Date created_date;
}
