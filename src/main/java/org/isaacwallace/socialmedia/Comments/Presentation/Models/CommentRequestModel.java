package org.isaacwallace.socialmedia.Comments.Presentation.Models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CommentRequestModel {
    String postid;
    String userid;
    String content;
}
