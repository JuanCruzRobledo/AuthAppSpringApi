package org.juanrobledo.authappspring.controllers;

import org.juanrobledo.authappspring.controllers.dto.AuthResponse;
import org.juanrobledo.authappspring.controllers.dto.AuthUserRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(AuthUserRequest authUserRequest){
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @PostMapping("/sign-up")
    public ResponseEntity<AuthResponse> register(AuthUserRequest authUserRequest){
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
