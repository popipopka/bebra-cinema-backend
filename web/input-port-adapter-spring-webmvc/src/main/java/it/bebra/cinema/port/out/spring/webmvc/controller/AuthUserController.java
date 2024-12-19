package it.bebra.cinema.port.out.spring.webmvc.controller;

import it.bebra.cinema.application.dto.UserAuthRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthUserController {
    private final AuthenticationManager authenticationManager;

    @PostMapping("api/v1/public/users/auth")
    public ResponseEntity<Void> authenticateUser(@RequestBody UserAuthRequestDto body) {
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(body.getUsername(), body.getPassword()));

        SecurityContext context = SecurityContextHolder.createEmptyContext();
        context.setAuthentication(auth);

        SecurityContextHolder.setContext(context);

        return ResponseEntity.ok().build();
    }
}
