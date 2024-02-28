package org.isaacwallace.socialmedia.Comments.Mapper;

import org.isaacwallace.socialmedia.Comments.DataAccess.Comment;
import org.isaacwallace.socialmedia.Comments.DataAccess.CommentIdentifier;
import org.isaacwallace.socialmedia.Comments.Presentation.Models.CommentRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CommentRequestMapper {
    @Mapping(target = "id", ignore = true)
    Comment requestModelToEntity(CommentRequestModel commentRequestModel, CommentIdentifier commentIdentifier);
}
