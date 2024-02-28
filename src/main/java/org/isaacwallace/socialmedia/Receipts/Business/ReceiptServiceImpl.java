package org.isaacwallace.socialmedia.Receipts.Business;

import org.isaacwallace.socialmedia.Posts.DataAccess.Post;
import org.isaacwallace.socialmedia.Posts.Presentation.Models.PostRequestModel;
import org.isaacwallace.socialmedia.Posts.Presentation.Models.PostResponseModel;
import org.isaacwallace.socialmedia.Receipts.DataAccess.Receipt;
import org.isaacwallace.socialmedia.Receipts.DataAccess.ReceiptIdentifier;
import org.isaacwallace.socialmedia.Receipts.DataAccess.ReceiptRepository;
import org.isaacwallace.socialmedia.Receipts.Mapper.ReceiptRequestMapper;
import org.isaacwallace.socialmedia.Receipts.Mapper.ReceiptResponseMapper;
import org.isaacwallace.socialmedia.Receipts.Presentation.Models.ReceiptRequestModel;
import org.isaacwallace.socialmedia.Receipts.Presentation.Models.ReceiptResponseModel;
import org.isaacwallace.socialmedia.Utils.Exceptions.InUseException;
import org.isaacwallace.socialmedia.Utils.Exceptions.InvalidInputException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceiptServiceImpl implements ReceiptService {
    private final ReceiptRepository receiptRepository;
    private final ReceiptResponseMapper receiptResponseMapper;
    private final ReceiptRequestMapper receiptRequestMapper;

    public ReceiptServiceImpl(ReceiptRepository receiptRepository, ReceiptResponseMapper receiptResponseMapper, ReceiptRequestMapper receiptRequestMapper) {
        this.receiptRepository = receiptRepository;
        this.receiptResponseMapper = receiptResponseMapper;
        this.receiptRequestMapper = receiptRequestMapper;
    }

    public List<ReceiptResponseModel> getAllReceipts() {
        return this.receiptResponseMapper.entityListToResponseModelList(this.receiptRepository.findAll());
    }
    public ReceiptResponseModel getReceiptById(String receiptid) {
        Receipt receipt = this.receiptRepository.findReceiptByReceiptIdentifier_Receiptid(receiptid);

        if (receipt == null) {
            throw new InvalidInputException("Unknown receiptid: " + receiptid);
        }

        return this.receiptResponseMapper.entityToResponseModel(receipt);
    }

    public ReceiptResponseModel addReceipt(ReceiptRequestModel receiptRequestModel) {
        Receipt newReceipt = this.receiptRequestMapper.requestModelToEntity(receiptRequestModel, new ReceiptIdentifier());

        return this.receiptResponseMapper.entityToResponseModel(newReceipt);
    }

    public ReceiptResponseModel editReceipt(String receiptid, ReceiptRequestModel receiptRequestModel) {
        Receipt receipt = this.receiptRepository.findReceiptByReceiptIdentifier_Receiptid(receiptid);

        if (receipt == null) {
            throw new InvalidInputException("Unknown receiptid: " + receiptid);
        }

        Receipt updatedReceipt = this.receiptRequestMapper.requestModelToEntity(receiptRequestModel, receipt.getReceiptIdentifier());

        this.receiptRepository.save(updatedReceipt);

        return this.receiptResponseMapper.entityToResponseModel(updatedReceipt);
    }

    public void deleteReceipt(String receiptid) {
        Receipt receipt = this.receiptRepository.findReceiptByReceiptIdentifier_Receiptid(receiptid);

        if (receipt == null) {
            throw new InvalidInputException("Unknown receiptid: " + receiptid);
        }

        try {
            this.receiptRepository.delete(receipt);
        } catch(DataIntegrityViolationException exception) {
            throw new InUseException("Receipt is in use by another entity, currently cannot delete.");
        }
    }
}
