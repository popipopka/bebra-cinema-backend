package it.bebra.cinema.port.in.spring.webmvc.controller;

import it.bebra.cinema.application.dto.request.UserCreateRequest;
import it.bebra.cinema.application.port.in.CreateUserInputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class CreateUserController {
    private final CreateUserInputPort createUserInputPort;

    @PostMapping("api/v1/users")
    public ResponseEntity<Void> createUser(@RequestBody UserCreateRequest body, UriComponentsBuilder uriBuilder) {
        int userId = createUserInputPort.invoke(body);

        return ResponseEntity
                .created(uriBuilder
                        .pathSegment("api/v1/users", "{userId}")
                        .buildAndExpand(Map.of("userId", userId))
                        .toUri())
                .build();
    }
}
