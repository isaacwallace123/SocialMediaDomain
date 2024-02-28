package org.isaacwallace.socialmedia.Users.Presentation;

import org.apache.catalina.connector.Response;
import org.isaacwallace.socialmedia.Users.Business.UserService;
import org.isaacwallace.socialmedia.Users.Presentation.Models.UserRequestModel;
import org.isaacwallace.socialmedia.Users.Presentation.Models.UserResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("")
    public ResponseEntity<List<UserResponseModel>> GetUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(this.userService.getAllUsers());
    }

    @GetMapping("{userid}")
    public ResponseEntity<UserResponseModel> GetUser(@PathVariable String userid) {
        return ResponseEntity.status(HttpStatus.OK).body(this.userService.getUserById(userid));
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponseModel> AddUser(@RequestBody UserRequestModel userRequestModel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.userService.addUser(userRequestModel));
    }

    @PutMapping(value = "{userid}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponseModel> EditUser(@PathVariable String userid, @RequestBody UserRequestModel userRequestModel) {
        return ResponseEntity.status(HttpStatus.OK).body(this.userService.editUser(userid, userRequestModel));
    }

    @DeleteMapping(value = "{userid}")
    public ResponseEntity<Void> DeleteUser(@PathVariable String userid) {
        this.userService.deleteUser(userid);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
