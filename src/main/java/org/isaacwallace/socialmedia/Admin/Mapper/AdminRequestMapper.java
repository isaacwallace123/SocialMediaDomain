package org.isaacwallace.socialmedia.Admin.Mapper;

import org.isaacwallace.socialmedia.Admin.DataAccess.AdminIdentifier;
import org.isaacwallace.socialmedia.Admin.Presentation.AdminRequestModel;
import org.isaacwallace.socialmedia.Users.DataAccess.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AdminRequestMapper {
    @Mapping(target = "id", ignore = true)
    User requestModelToEntity(AdminRequestModel adminRequestModel, AdminIdentifier adminIdentifier);
}
