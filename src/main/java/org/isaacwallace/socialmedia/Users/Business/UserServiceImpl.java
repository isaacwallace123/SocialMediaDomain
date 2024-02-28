package org.isaacwallace.socialmedia.Users.Business;

import org.isaacwallace.socialmedia.Users.DataAccess.User;
import org.isaacwallace.socialmedia.Users.DataAccess.UserIdentifier;
import org.isaacwallace.socialmedia.Users.DataAccess.UserRepository;
import org.isaacwallace.socialmedia.Users.Mapper.UserRequestMapper;
import org.isaacwallace.socialmedia.Users.Mapper.UserResponseMapper;
import org.isaacwallace.socialmedia.Users.Presentation.Models.UserRequestModel;
import org.isaacwallace.socialmedia.Users.Presentation.Models.UserResponseModel;
import org.isaacwallace.socialmedia.Utils.Exceptions.InUseException;
import org.isaacwallace.socialmedia.Utils.Exceptions.InvalidInputException;
import org.isaacwallace.socialmedia.Utils.Exceptions.NotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
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
        return this.userResponseMapper.entityListToResponseModelList(this.userRepository.findAll());
    }

    public UserResponseModel getUserById(String userid) {
        User user = this.userRepository.findUserByUserIdentifier_Userid(userid);

        if (user == null) {
            throw new InvalidInputException("Unknown userId: " + userid);
        }

        return this.userResponseMapper.entityToResponseModel(user);
    }

    public UserResponseModel addUser(UserRequestModel userRequestModel) {
        User newUser = this.userRequestMapper.requestModelToEntity(userRequestModel, new UserIdentifier());

        return userResponseMapper.entityToResponseModel(newUser);
    }

    public UserResponseModel editUser(String userid, UserRequestModel userRequestModel) {
        User user = this.userRepository.findUserByUserIdentifier_Userid(userid);

        if (user == null) {
            throw new InvalidInputException("Unknown userid: " + userid);
        }

        User updatedUser = this.userRequestMapper.requestModelToEntity(userRequestModel, user.getUserIdentifier());

        this.userRepository.save(updatedUser);

        return this.userResponseMapper.entityToResponseModel(updatedUser);
    }

    public void deleteUser(String userid) {
        User user = this.userRepository.findUserByUserIdentifier_Userid(userid);

        if (user == null) {
            throw new InvalidInputException("Unknown userid: " + userid);
        }

        try {
            this.userRepository.delete(user);
        } catch(DataIntegrityViolationException exception) {
            throw new InUseException("User is in use by another entity, currently cannot delete.");
        }
    }
}
