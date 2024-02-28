package org.isaacwallace.socialmedia.Receipts.Business;

import org.isaacwallace.socialmedia.Receipts.Presentation.Models.ReceiptRequestModel;
import org.isaacwallace.socialmedia.Receipts.Presentation.Models.ReceiptResponseModel;

import java.util.List;

public interface ReceiptService {
    public List<ReceiptResponseModel> getAllReceipts();
    public ReceiptResponseModel getReceiptById(String receiptid);
    public ReceiptResponseModel addReceipt(ReceiptRequestModel receiptRequestModel);
}
