package org.isaacwallace.socialmedia.Posts.Presentation.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostRequestModel extends RepresentationModel<PostRequestModel> {
    private String content;

}
