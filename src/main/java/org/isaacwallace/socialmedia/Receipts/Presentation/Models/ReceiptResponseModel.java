package org.isaacwallace.socialmedia.Receipts.Presentation.Models;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

@Data
public class ReceiptResponseModel extends RepresentationModel<ReceiptResponseModel> {
    private String receiptid;
    private String postid;
    private String userid;
    private Double subtotal;
    private String currency;
}
