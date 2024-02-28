package org.isaacwallace.socialmedia.Users.Business;

import org.isaacwallace.socialmedia.Users.DataAccess.UserRepository;
import org.isaacwallace.socialmedia.Users.Presentation.UserResponseModel;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    public List<UserResponseModel> getAllUsers();
    public UserResponseModel getUserById(String userid);
}
