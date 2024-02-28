package org.isaacwallace.socialmedia.Receipts.Presentation;

import org.isaacwallace.socialmedia.Posts.Presentation.Models.PostRequestModel;
import org.isaacwallace.socialmedia.Posts.Presentation.Models.PostResponseModel;
import org.isaacwallace.socialmedia.Receipts.Business.ReceiptService;
import org.isaacwallace.socialmedia.Receipts.Presentation.Models.ReceiptRequestModel;
import org.isaacwallace.socialmedia.Receipts.Presentation.Models.ReceiptResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/receipts")
public class ReceiptController {
    private final ReceiptService receiptService;

    public ReceiptController(ReceiptService receiptService) {
        this.receiptService = receiptService;
    }

    @GetMapping("")
    public ResponseEntity<List<ReceiptResponseModel>> GetReceipts() {
        return ResponseEntity.status(HttpStatus.OK).body(this.receiptService.getAllReceipts());
    }

    @GetMapping("{receiptid}")
    public ResponseEntity<ReceiptResponseModel> GetReceipt(@PathVariable String receiptid) {
        return ResponseEntity.status(HttpStatus.OK).body(this.receiptService.getReceiptById(receiptid));
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ReceiptResponseModel> AddReceipt(@RequestBody ReceiptRequestModel receiptRequestModel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.receiptService.addReceipt(receiptRequestModel));
    }

    @PutMapping(value = "{receiptid}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ReceiptResponseModel> EditPost(@PathVariable String receiptid, @RequestBody ReceiptRequestModel receiptRequestModel) {
        return ResponseEntity.status(HttpStatus.OK).body(this.receiptService.editReceipt(receiptid, receiptRequestModel));
    }

    @DeleteMapping(value = "{receiptid}")
    public ResponseEntity<Void> DeletePost(@PathVariable String receiptid) {
        this.receiptService.deleteReceipt(receiptid);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
