package org.isaacwallace.socialmedia.Posts.Mapper;

import org.isaacwallace.socialmedia.Comments.DataAccess.Comment;
import org.isaacwallace.socialmedia.Posts.DataAccess.Post;
import org.isaacwallace.socialmedia.Posts.Presentation.Models.PostCommentsResponseModel;
import org.isaacwallace.socialmedia.Posts.Presentation.Models.PostResponseModel;
import org.isaacwallace.socialmedia.Posts.Presentation.PostCommentsController;
import org.isaacwallace.socialmedia.Posts.Presentation.PostController;
import org.isaacwallace.socialmedia.Users.DataAccess.User;
import org.isaacwallace.socialmedia.Users.Presentation.Models.UserCommentsResponseModel;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.hateoas.Link;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Mapper(componentModel = "spring")
public interface PostResponseMapper {
    @Mapping(expression = "java(post.getPostIdentifier().getPostid())", target = "postid")
    PostResponseModel entityToResponseModel(Post post);
    List<PostResponseModel> entitiesToResponseModelList(List<Post> posts);

    List<PostResponseModel> entityListToResponseModelList(List<Post> postList);
    PostCommentsResponseModel commentToAggregateResponseModel(Post post);

    @AfterMapping
    default void addLinks(@MappingTarget PostResponseModel postResponseModel, Post post) {
        Link selfLink = linkTo(methodOn(PostController.class).GetPost(post.getPostIdentifier().getPostid())).withSelfRel();
        postResponseModel.add(selfLink);

        Link allLink = linkTo(methodOn(PostController.class).GetPosts()).withRel("posts");
        postResponseModel.add(allLink);

        Link commentLink = linkTo(methodOn(PostCommentsController.class).GetComments(postResponseModel.getPostid())).withRel("comments");
        postResponseModel.add(commentLink);
    }
}
