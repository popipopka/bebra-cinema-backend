package it.bebra.cinema.port.in.spring.webmvc.controller;

import it.bebra.cinema.application.dto.request.UserUpdateRequest;
import it.bebra.cinema.application.port.in.UpdateUserInputPort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UpdateCurrentUserController {
    private final UpdateUserInputPort updateUserInputPort;

    @PatchMapping("api/v1/users/me")
    public ResponseEntity<Void> updateUser(
            @AuthenticationPrincipal UserDetails userDetails,
            @Valid @RequestBody UserUpdateRequest body
    ) {
        updateUserInputPort.invoke(userDetails.getUsername(), body);

        return ResponseEntity.ok().build();
    }
}
