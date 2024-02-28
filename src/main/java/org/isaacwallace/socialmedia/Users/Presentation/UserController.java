package org.isaacwallace.socialmedia.Users.Presentation;

import org.isaacwallace.socialmedia.Users.Business.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
    }

    @GetMapping("{userid}")
    public ResponseEntity<UserResponseModel> GetUser(@PathVariable String userid) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(userid));
    }
}
