package it.bebra.cinema.port.in.spring.webmvc;

import it.bebra.cinema.application.dto.request.UserUpdateRequestDto;
import it.bebra.cinema.application.port.in.UpdateUserInputPort;
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
    public ResponseEntity<Void> updateUser(@AuthenticationPrincipal UserDetails userDetails,
                                           @RequestBody UserUpdateRequestDto body) {
        updateUserInputPort.invoke(userDetails.getUsername(), body);

        return ResponseEntity.ok().build();
    }
}
