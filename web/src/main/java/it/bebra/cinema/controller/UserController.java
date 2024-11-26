package it.bebra.cinema.controller;

import it.bebra.cinema.usecase.dto.UserAuthRequestDto;
import it.bebra.cinema.usecase.dto.UserCreateRequestDto;
import it.bebra.cinema.usecase.port.in.CreateUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final CreateUserUseCase createUserUseCase;

    private final AuthenticationManager authenticationManager;

    @PostMapping("/auth")
    public ResponseEntity<Void> authenticateUser(@RequestBody UserAuthRequestDto body) {
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(body.getUsername(), body.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(auth);

        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody UserCreateRequestDto body) {
        createUserUseCase.invoke(body);

        return ResponseEntity.ok().build();
    }
}
