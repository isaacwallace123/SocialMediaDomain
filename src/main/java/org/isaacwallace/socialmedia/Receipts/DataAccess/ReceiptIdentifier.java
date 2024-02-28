package org.isaacwallace.socialmedia.Receipts.DataAccess;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.util.UUID;

@Embeddable
@Getter
public class ReceiptIdentifier {
    @Column(name = "receiptid")
    private String receiptid;

    public ReceiptIdentifier(){
        this.receiptid = UUID.randomUUID().toString();
    }
}
