package com.app.todo.controller;

import com.app.todo.entity.AuthRequest;
import com.app.todo.entity.Login;
import com.app.todo.entity.User;
import com.app.todo.service.JwtService;
import com.app.todo.service.LoginService;
import com.app.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;

@RestController
public class UserController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @Autowired
    JwtService jwtService;

    @Autowired
    LoginService loginService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping(value="/user/register", consumes = "application/json", produces = "application/json")
    public User registerUser(@RequestBody User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        User createdUser = userService.registerUser(user);
        createdUser.setPassword("");
        return createdUser;
    }

    @PostMapping(value="/user/login", consumes = "application/json", produces = "application/json")
    public Login loginUser(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if(authentication.isAuthenticated()) {
            String jwtAuthToken = jwtService.generateToken(authRequest.getUsername());
            Login login = new Login();
            login.setUsername(authRequest.getUsername());
            login.setToken(jwtAuthToken);
            loginService.addLogin(login);
            return login;
        } else {
            throw new UsernameNotFoundException("User not found!!");
        }

    }
}
