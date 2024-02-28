package org.isaacwallace.socialmedia.Receipts.Mapper;

import org.isaacwallace.socialmedia.Posts.DataAccess.Post;
import org.isaacwallace.socialmedia.Posts.Presentation.Models.PostResponseModel;
import org.isaacwallace.socialmedia.Posts.Presentation.PostController;
import org.isaacwallace.socialmedia.Receipts.DataAccess.Receipt;
import org.isaacwallace.socialmedia.Receipts.Presentation.Models.ReceiptResponseModel;
import org.isaacwallace.socialmedia.Receipts.Presentation.ReceiptController;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.hateoas.Link;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Mapper(componentModel = "spring")
public interface ReceiptResponseMapper {
    @Mapping(expression = "java(receipt.getReceiptIdentifier().getReceiptid())", target = "receiptid")
    ReceiptResponseModel entityToResponseModel(Receipt receipt);
    List<ReceiptResponseModel> entitiesToResponseModelList(List<Receipt> receipts);
    List<ReceiptResponseModel> entityListToResponseModelList(List<Receipt> receipts);

    @AfterMapping
    default void addLinks(@MappingTarget ReceiptResponseModel receiptResponseModel, Receipt receipt) {
        Link selfLink = linkTo(methodOn(ReceiptController.class).GetReceipt(receipt.getReceiptIdentifier().getReceiptid())).withSelfRel();
        receiptResponseModel.add(selfLink);

        Link allLink = linkTo(methodOn(ReceiptController.class).GetReceipts()).withRel("receipts");
        receiptResponseModel.add(allLink);
    }
}
