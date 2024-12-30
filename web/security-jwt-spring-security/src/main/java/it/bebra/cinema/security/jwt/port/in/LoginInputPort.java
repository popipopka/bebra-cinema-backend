package it.bebra.cinema.security.jwt.port.in;

import it.bebra.cinema.security.jwt.dto.LoginRequestDto;
import it.bebra.cinema.security.jwt.dto.LoginResponseDto;

public interface LoginInputPort {
    LoginResponseDto invoke(LoginRequestDto loginRequestDto);
}
