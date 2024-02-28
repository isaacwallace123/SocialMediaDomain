package org.isaacwallace.socialmedia.Users.Business;

import org.isaacwallace.socialmedia.Posts.DataAccess.Post;
import org.isaacwallace.socialmedia.Posts.DataAccess.PostRepository;
import org.isaacwallace.socialmedia.Posts.Mapper.PostResponseMapper;
import org.isaacwallace.socialmedia.Posts.Presentation.Models.PostResponseModel;
import org.isaacwallace.socialmedia.Receipts.DataAccess.Receipt;
import org.isaacwallace.socialmedia.Receipts.DataAccess.ReceiptRepository;
import org.isaacwallace.socialmedia.Receipts.Mapper.ReceiptResponseMapper;
import org.isaacwallace.socialmedia.Receipts.Presentation.Models.ReceiptResponseModel;
import org.isaacwallace.socialmedia.Users.DataAccess.User;
import org.isaacwallace.socialmedia.Users.DataAccess.UserRepository;
import org.isaacwallace.socialmedia.Users.Mapper.UserResponseMapper;
import org.isaacwallace.socialmedia.Users.Presentation.Models.UserPostsResponseModel;
import org.isaacwallace.socialmedia.Users.Presentation.Models.UserReceiptsResponseModel;
import org.isaacwallace.socialmedia.Utils.Exceptions.InvalidInputException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserReceiptsServiceImpl implements UserReceiptsService {
    private final UserRepository userRepository;
    private final ReceiptRepository receiptRepository;
    private final UserResponseMapper userResponseMapper;
    private final ReceiptResponseMapper receiptResponseMapper;

    public UserReceiptsServiceImpl(UserRepository userRepository, ReceiptRepository receiptRepository, UserResponseMapper userResponseMapper, ReceiptResponseMapper receiptResponseMapper) {
        this.userRepository = userRepository;
        this.receiptRepository = receiptRepository;
        this.userResponseMapper = userResponseMapper;
        this.receiptResponseMapper = receiptResponseMapper;
    }

    public UserReceiptsResponseModel getAllReceiptsByUserId(String userid) {
        User user = this.userRepository.findUserByUserIdentifier_Userid(userid);

        if (user == null) {
            throw new InvalidInputException("Unknown userid: " + userid);
        }

        List<Receipt> receiptList = this.receiptRepository.findReceiptsByPostid(userid);
        List<ReceiptResponseModel> receipts = this.receiptResponseMapper.entitiesToResponseModelList(receiptList);

        UserReceiptsResponseModel userModel = this.userResponseMapper.receiptToAggregateResponseModel(user);
        userModel.setReceipts(receipts);

        return userModel;
    }
}
