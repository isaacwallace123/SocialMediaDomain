package org.isaacwallace.socialmedia.Users.Presentation;

import org.isaacwallace.socialmedia.Users.Business.UserReceiptsService;
import org.isaacwallace.socialmedia.Users.Presentation.Models.UserReceiptsResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users/{userid}/receipts")
public class UserReceiptsController {
    private final UserReceiptsService userReceiptsService;

    public UserReceiptsController(UserReceiptsService userReceiptsService) {
        this.userReceiptsService = userReceiptsService;
    }

    @GetMapping("")
    public ResponseEntity<UserReceiptsResponseModel> GetReceipts(@PathVariable String userid) {
        return ResponseEntity.status(HttpStatus.OK).body(this.userReceiptsService.getAllReceiptsByUserId(userid));
    }
}