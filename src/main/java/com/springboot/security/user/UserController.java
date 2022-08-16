package com.springboot.security.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private UserProvider userProvider;

    @Autowired
    public UserController(UserProvider userProvider) {
        this.userProvider = userProvider;
    }

/*    @GetMapping("/users")
    public List<GetUserRes> getUser() {
        List<GetUserRes> userRes = userProvider.getUser();
        return userRes;
    }


 */
}