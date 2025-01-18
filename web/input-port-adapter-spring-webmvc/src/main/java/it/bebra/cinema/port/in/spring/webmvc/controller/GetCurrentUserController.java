package it.bebra.cinema.port.in.spring.webmvc.controller;

import it.bebra.cinema.port.in.spring.webmvc.dto.UserDetailResponseDto;
import it.bebra.cinema.application.port.in.GetUserInputPort;
import it.bebra.cinema.port.in.spring.webmvc.mapper.UserDataMapper;
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
    private final UserDataMapper userDataMapper;

    @GetMapping("api/v1/users/me")
    public ResponseEntity<UserDetailResponseDto> getCurrentUser(@AuthenticationPrincipal UserDetails userDetails) {
        var user = userDataMapper.toDetailDto(
                getUserInputPort.invoke(userDetails.getUsername())
        );

        return ResponseEntity.ok(user);
    }
}
