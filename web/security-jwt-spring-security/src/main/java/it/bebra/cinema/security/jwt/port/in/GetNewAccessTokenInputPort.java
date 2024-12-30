package it.bebra.cinema.security.jwt.port.in;

import it.bebra.cinema.security.jwt.dto.AccessTokenDto;

public interface GetNewAccessTokenInputPort {

    AccessTokenDto invoke(String refreshToken);
}
