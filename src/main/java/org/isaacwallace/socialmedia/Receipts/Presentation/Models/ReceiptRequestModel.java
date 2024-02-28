package org.isaacwallace.socialmedia.Receipts.Presentation.Models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ReceiptRequestModel {
    String userid;
    String postid;

    Double subtotal;
    String currency;
}
