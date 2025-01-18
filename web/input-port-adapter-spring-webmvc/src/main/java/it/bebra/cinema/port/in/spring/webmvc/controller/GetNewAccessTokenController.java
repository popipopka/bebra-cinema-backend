package it.bebra.cinema.port.in.spring.webmvc.controller;

import it.bebra.cinema.security.jwt.dto.AccessTokenDto;
import it.bebra.cinema.security.jwt.dto.RefreshTokenDto;
import it.bebra.cinema.security.jwt.port.in.GetNewAccessTokenInputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GetNewAccessTokenController {
    private final GetNewAccessTokenInputPort getNewAccessTokenInputPort;

    @PostMapping("api/v1/auth/token")
    public ResponseEntity<AccessTokenDto> getNewAccessToken(@RequestBody RefreshTokenDto body) {
        var accessToken = getNewAccessTokenInputPort.invoke(body.getRefreshToken());

        return ResponseEntity.ok(accessToken);
    }
}
