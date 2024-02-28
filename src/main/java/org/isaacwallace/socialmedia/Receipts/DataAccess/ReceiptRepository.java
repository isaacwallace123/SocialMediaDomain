package org.isaacwallace.socialmedia.Receipts.DataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReceiptRepository extends JpaRepository<Receipt, Integer> {
    public Receipt findReceiptByReceiptIdentifier_Receiptid(String receiptid);
    public List<Receipt> findReceiptsByPostid(String postid);
    public List<Receipt> findReceiptByUserid(String userid);
}