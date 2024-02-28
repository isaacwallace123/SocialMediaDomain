package org.isaacwallace.socialmedia.Receipts.Mapper;

import org.isaacwallace.socialmedia.Receipts.DataAccess.Receipt;
import org.isaacwallace.socialmedia.Receipts.DataAccess.ReceiptIdentifier;
import org.isaacwallace.socialmedia.Receipts.Presentation.Models.ReceiptRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReceiptRequestMapper {
    @Mapping(target = "id", ignore = true)
    Receipt requestModelToEntity(ReceiptRequestModel receiptRequestModel, ReceiptIdentifier receiptIdentifier);
}
