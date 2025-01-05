package it.bebra.cinema.port.in.spring.webmvc;

import it.bebra.cinema.application.dto.response.UserDetailResponseDto;
import it.bebra.cinema.application.port.in.GetUserInputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GetCurrentUserController {
    private final GetUserInputPort getUserInputPort;

    @GetMapping("api/v1/users/me")
    public ResponseEntity<UserDetailResponseDto> getCurrentUser(@AuthenticationPrincipal UserDetails userDetails) {
        var user = getUserInputPort.invoke(userDetails.getUsername());

        return ResponseEntity.ok(user);
    }
}
