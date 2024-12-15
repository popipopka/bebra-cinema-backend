package it.bebra.cinema.port.out.spring.webmvc.controller;

import it.bebra.cinema.application.dto.UserCreateRequestDto;
import it.bebra.cinema.application.port.in.CreateUserInputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CreateUserController {
    private final CreateUserInputPort createUserInputPort;

    @PostMapping("api/v1/users")
    public ResponseEntity<Void> createUser(@RequestBody UserCreateRequestDto body) {
        createUserInputPort.invoke(body);

        return ResponseEntity.ok().build();
    }
}
