package org.isaacwallace.socialmedia.Users.Mapper;

import org.isaacwallace.socialmedia.Users.DataAccess.User;
import org.isaacwallace.socialmedia.Users.Presentation.UserController;
import org.isaacwallace.socialmedia.Users.Presentation.UserResponseModel;
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

    List<UserResponseModel> entityListToResponseModelList(List<User> userList);

    /*@AfterMapping
    default void addLinks(@MappingTarget UserResponseModel model, User user) {
        Link selfLink = linkTo(methodOn(UserController.class));



    }*/
}
