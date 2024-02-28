package org.isaacwallace.socialmedia.Receipts.Business;

import org.isaacwallace.socialmedia.Posts.Presentation.Models.PostRequestModel;
import org.isaacwallace.socialmedia.Posts.Presentation.Models.PostResponseModel;
import org.isaacwallace.socialmedia.Receipts.Presentation.Models.ReceiptRequestModel;
import org.isaacwallace.socialmedia.Receipts.Presentation.Models.ReceiptResponseModel;

import java.util.List;

public interface ReceiptService {
    public List<ReceiptResponseModel> getAllReceipts();
    public ReceiptResponseModel getReceiptById(String receiptid);
    public ReceiptResponseModel addReceipt(ReceiptRequestModel receiptRequestModel);
    public ReceiptResponseModel editReceipt(String receiptid, ReceiptRequestModel receiptRequestModel);
    public void deleteReceipt(String receiptid);
}
