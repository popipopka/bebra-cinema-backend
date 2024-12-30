package it.bebra.cinema.port.in.spring.webmvc;

import it.bebra.cinema.security.jwt.dto.LoginRequestDto;
import it.bebra.cinema.security.jwt.dto.LoginResponseDto;
import it.bebra.cinema.security.jwt.port.in.LoginInputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginController {
    private final LoginInputPort loginInputPort;

    @PostMapping("api/v1/auth/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto body) {
        var tokens = loginInputPort.invoke(body);

        return ResponseEntity.ok(tokens);
    }
}
