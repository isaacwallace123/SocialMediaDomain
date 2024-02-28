package org.isaacwallace.socialmedia.Posts.Presentation.Models;

import lombok.Data;
import org.isaacwallace.socialmedia.Comments.Presentation.Models.CommentResponseModel;
import org.isaacwallace.socialmedia.Posts.DataAccess.Media;

import java.util.Date;
import java.util.List;

@Data
public class PostCommentsResponseModel {
    private String postid;
    private String userid;
    private String content;
    private Date created_date;
    private Media media;
    private List<CommentResponseModel> Comments;
}
