package it.bebra.cinema.port.in.spring.webmvc;

import it.bebra.cinema.application.port.in.SoftDeleteUserInputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SoftDeleteCurrentUserController {
    private final SoftDeleteUserInputPort softDeleteUserInputPort;

    @DeleteMapping("api/v1/users/me")
    public ResponseEntity<Void> softDeleteUser(@AuthenticationPrincipal UserDetails userDetails) {
        softDeleteUserInputPort.invoke(userDetails.getUsername());

        return ResponseEntity.ok().build();
    }
}
