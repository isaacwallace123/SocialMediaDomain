package org.isaacwallace.socialmedia.Comments.Mapper;

import org.isaacwallace.socialmedia.Comments.DataAccess.Comment;
import org.isaacwallace.socialmedia.Comments.Presentation.CommentsController;
import org.isaacwallace.socialmedia.Comments.Presentation.Models.CommentResponseModel;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.hateoas.Link;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Mapper(componentModel = "spring")
public interface CommentResponseMapper {
    @Mapping(expression = "java(comment.getCommentIdentifier().getCommentid())", target = "commentid")
    CommentResponseModel entityToResponseModel(Comment comment);
    List<CommentResponseModel> entitiesToResponseModelList(List<Comment> comments);
    List<CommentResponseModel> entityListToResponseModelList(List<Comment> comments);

    @AfterMapping
    default void addLinks(@MappingTarget CommentResponseModel commentResponseModel, Comment comment) {
        Link selfLink = linkTo(methodOn(CommentsController.class).GetComment(comment.getCommentIdentifier().getCommentid())).withSelfRel();
        commentResponseModel.add(selfLink);

        Link allLink = linkTo(methodOn(CommentsController.class).GetComments()).withRel("comments");
        commentResponseModel.add(allLink);
    }
}
