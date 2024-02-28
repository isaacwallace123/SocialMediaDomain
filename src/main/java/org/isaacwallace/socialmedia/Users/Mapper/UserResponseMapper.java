package org.isaacwallace.socialmedia.Users.Mapper;

import org.isaacwallace.socialmedia.Users.DataAccess.User;
import org.isaacwallace.socialmedia.Users.Presentation.Models.UserPostsResponseModel;
import org.isaacwallace.socialmedia.Users.Presentation.UserController;
import org.isaacwallace.socialmedia.Users.Presentation.Models.UserResponseModel;
import org.isaacwallace.socialmedia.Users.Presentation.UserPostsController;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.hateoas.Link;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserResponseMapper {
    @Mapping(expression = "java(user.getUserIdentifier().getUserid())", target = "userid")
    UserResponseModel entityToResponseModel(User user);
    List<UserResponseModel> entityListToResponseModelList(List<User> users);

    UserPostsResponseModel entityToAggregateResponseModel(User user);

    @AfterMapping
    default void addLinks(@MappingTarget UserResponseModel userResponseModel, User user) {
        Link selfLink = linkTo(methodOn(UserController.class).GetUser(user.getUserIdentifier().getUserid())).withSelfRel();
        userResponseModel.add(selfLink);

        Link allLink = linkTo(methodOn(UserController.class).GetUsers()).withRel("users");
        userResponseModel.add(allLink);

        Link postLink = linkTo(methodOn(UserPostsController.class).GetPosts(userResponseModel.getUserid())).withRel("posts");
        userResponseModel.add(postLink);
    }
}
