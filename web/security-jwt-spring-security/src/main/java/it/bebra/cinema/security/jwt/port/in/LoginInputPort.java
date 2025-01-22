package it.bebra.cinema.security.jwt.port.in;

import it.bebra.cinema.security.jwt.dto.LoginRequestDto;
import it.bebra.cinema.security.jwt.dto.TokensData;

public interface LoginInputPort {
    TokensData invoke(LoginRequestDto loginRequestDto);
}
