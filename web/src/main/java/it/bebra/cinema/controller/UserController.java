package it.bebra.cinema.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {

    @PostMapping("/authenticate")
    public ResponseEntity<Void> authenticateUser() {

    }

    @PostMapping()
    public ResponseEntity createUser() {

    }
}
