package org.isaacwallace.socialmedia.Users.Business;

import org.isaacwallace.socialmedia.Users.DataAccess.User;
import org.isaacwallace.socialmedia.Users.DataAccess.UserRepository;
import org.isaacwallace.socialmedia.Users.Mapper.UserRequestMapper;
import org.isaacwallace.socialmedia.Users.Mapper.UserResponseMapper;
import org.isaacwallace.socialmedia.Users.Presentation.UserResponseModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserResponseMapper userResponseMapper;
    private final UserRequestMapper userRequestMapper;

    public UserServiceImpl(UserRepository userRepository, UserResponseMapper userResponseMapper, UserRequestMapper userRequestMapper) {
        this.userRepository = userRepository;
        this.userRequestMapper = userRequestMapper;
        this.userResponseMapper = userResponseMapper;
    }

    public List<UserResponseModel> getAllUsers() {
        return userResponseMapper.entityListToResponseModelList(this.userRepository.findAll());
    }

    public UserResponseModel getUserById(String userid) {
        User user = this.userRepository.findUserByUserIdentifier_Userid(userid);

        

        return userResponseMapper.entityToResponseModel(user);
    }
}
