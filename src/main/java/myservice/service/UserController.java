package myservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @MutationMapping
    public User changeUser(@Argument String newName) {
        User user = userService.getUserById(1L);
        if (user == null) {
            throw new RuntimeException("User not found");
        } else {
            user.setName(newName);
        }
        return user;
    }
}
