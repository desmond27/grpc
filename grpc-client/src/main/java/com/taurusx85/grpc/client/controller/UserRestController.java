package com.taurusx85.grpc.client.controller;

import com.taurusx85.grpc.client.dto.input.UserCreationInput;
import com.taurusx85.grpc.client.service.UserRestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {
    private final UserRestService userRestService;

    public UserRestController(UserRestService userRestService) {
        this.userRestService = userRestService;
    }

    @PostMapping
    public ResponseEntity<Integer> createUser(@RequestBody UserCreationInput userCreationInput) {
        Integer id = userRestService.createUser(userCreationInput.getName());
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }
}
