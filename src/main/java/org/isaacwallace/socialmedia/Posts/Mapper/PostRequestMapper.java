package org.isaacwallace.socialmedia.Posts.Mapper;

import org.isaacwallace.socialmedia.Posts.DataAccess.Post;
import org.isaacwallace.socialmedia.Posts.DataAccess.PostIdentifier;
import org.isaacwallace.socialmedia.Posts.Presentation.Models.PostRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PostRequestMapper {
    @Mapping(target = "id", ignore = true)
    Post requestModelToEntity(PostRequestModel postRequestModel, PostIdentifier postIdentifier);
}
