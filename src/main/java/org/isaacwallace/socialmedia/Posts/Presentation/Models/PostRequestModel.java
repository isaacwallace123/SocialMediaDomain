package org.isaacwallace.socialmedia.Posts.Presentation.Models;

import lombok.*;
import org.isaacwallace.socialmedia.Posts.DataAccess.Media;
import org.springframework.hateoas.RepresentationModel;

import java.util.Date;

@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PostRequestModel extends RepresentationModel<PostRequestModel> {
    String userid;
    String content;
    Date created_date;
    Media media;
}
