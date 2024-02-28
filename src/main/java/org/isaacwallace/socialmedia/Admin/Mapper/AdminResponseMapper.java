package org.isaacwallace.socialmedia.Admin.Mapper;

import org.isaacwallace.socialmedia.Admin.DataAccess.Admin;
import org.isaacwallace.socialmedia.Users.Presentation.UserResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AdminResponseMapper {
    @Mapping(expression = "java(admin.getAdminIdentifier().getAdminid())", target = "adminid")
    UserResponseModel entityToResponseModel(Admin admin);

    List<UserResponseModel> entityListToResponseModelList(List<Admin> adminList);

    /*@AfterMapping
    default void addLinks(@MappingTarget UserResponseModel model, User user) {
        Link selfLink = linkTo(methodOn(UserController.class));



    }*/
}
