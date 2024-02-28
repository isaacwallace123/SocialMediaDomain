package org.isaacwallace.socialmedia.Users.Mapper;

import org.isaacwallace.socialmedia.Users.DataAccess.User;
import org.isaacwallace.socialmedia.Users.DataAccess.UserIdentifier;
import org.isaacwallace.socialmedia.Users.Presentation.UserRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserRequestMapper {
    @Mapping(target = "id", ignore = true)
    User requestModelToEntity(UserRequestModel userRequestModel, UserIdentifier userIdentifier);
}
