package org.isaacwallace.socialmedia.Users.Business;

import org.isaacwallace.socialmedia.Users.Presentation.Models.UserRequestModel;
import org.isaacwallace.socialmedia.Users.Presentation.Models.UserResponseModel;

import java.util.List;


public interface UserService {
    public List<UserResponseModel> getAllUsers();
    public UserResponseModel getUserById(String userid);
    public UserResponseModel addUser(UserRequestModel userRequestModel);
    public UserResponseModel editUser(String userid, UserRequestModel userRequestModel);
    public void deleteUser(String userid);

}
