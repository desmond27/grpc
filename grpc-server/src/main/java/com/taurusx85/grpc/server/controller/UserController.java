package com.taurusx85.grpc.server.controller;

import com.taurusx85.grpc.server.dao.UserDAO;
import com.taurusx85.grpc.server.entity.UserNameRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users-rest")
public class UserController {

    private UserDAO userDAO;

    public UserController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @PostMapping
    public ResponseEntity<Integer> createUser(@RequestBody UserNameRequest usernameRequest) {
        return new ResponseEntity<>(userDAO.create(usernameRequest.getName()), HttpStatus.CREATED);
    }
}
