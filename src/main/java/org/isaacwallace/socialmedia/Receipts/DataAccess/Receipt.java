package org.isaacwallace.socialmedia.Receipts.DataAccess;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "receipts")
@Data
@NoArgsConstructor
public class Receipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Embedded
    private ReceiptIdentifier receiptIdentifier;

    private String postid;
    private String userid;

    private Double subtotal;
    private String currency;

    public Receipt(@NotNull String postid, @NotNull String userid, @NotNull Double subtotal, @NotNull String currency) {
        this.userid = userid;
        this.postid = postid;
        this.subtotal = subtotal;
        this.currency = currency;
    }
}
