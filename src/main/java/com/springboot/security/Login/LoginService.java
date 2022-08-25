package com.springboot.security.Login;


import com.springboot.security.user.UserDao;
import com.springboot.security.user.UserProvider;
import com.springboot.security.utils.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class LoginService {
    private final UserDao userDao;
    private final UserProvider userProvider;
    private final JwtService jwtService;
    @Autowired
    public LoginService(UserDao userDao, UserProvider userProvider, JwtService jwtService) {
        this.userDao = userDao;
        this.userProvider = userProvider;
        this.jwtService = jwtService;

    }

}
