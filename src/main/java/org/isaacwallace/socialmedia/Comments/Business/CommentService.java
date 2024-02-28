package org.isaacwallace.socialmedia.Comments.Business;

import org.isaacwallace.socialmedia.Comments.Presentation.Models.CommentRequestModel;
import org.isaacwallace.socialmedia.Comments.Presentation.Models.CommentResponseModel;

import java.util.List;

public interface CommentService {
    public List<CommentResponseModel> getAllComments();
    public CommentResponseModel getCommentById(String commentid);
    public CommentResponseModel addComment(CommentRequestModel commentRequestModel);
    public CommentResponseModel editComment(String commentid, CommentRequestModel commentRequestModel);
    public void deleteComment(String commentid);
}
