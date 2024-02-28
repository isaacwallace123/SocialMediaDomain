package org.isaacwallace.socialmedia.Admins.Mapper;

import org.isaacwallace.socialmedia.Admins.DataAccess.Admin;
import org.isaacwallace.socialmedia.Admins.Presentation.AdminController;
import org.isaacwallace.socialmedia.Admins.Presentation.Models.AdminResponseModel;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.hateoas.Link;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Mapper(componentModel = "spring")
public interface AdminResponseMapper {
    @Mapping(expression = "java(admin.getAdminIdentifier().getAdminid())", target = "adminid")
    AdminResponseModel entityToResponseModel(Admin admin);

    List<AdminResponseModel> entityListToResponseModelList(List<Admin> adminList);

    @AfterMapping
    default void addLinks(@MappingTarget AdminResponseModel adminResponseModel, Admin admin) {
        Link selfLink = linkTo(methodOn(AdminController.class).GetAdminById(admin.getAdminIdentifier().getAdminid())).withSelfRel();
        adminResponseModel.add(selfLink);

        Link allLink = linkTo(methodOn(AdminController.class).GetAdmins()).withRel("admins");
        adminResponseModel.add(allLink);
    }
}
