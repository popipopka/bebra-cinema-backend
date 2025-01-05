package it.bebra.cinema.security.jwt.port.in.usecase;

import it.bebra.cinema.application.exception.UserNotFoundException;
import it.bebra.cinema.application.port.out.UserOutputPort;
import it.bebra.cinema.domain.User;
import it.bebra.cinema.security.jwt.exception.JwtAuthenticationException;
import it.bebra.cinema.security.jwt.domain.Token;
import it.bebra.cinema.security.jwt.dto.AccessTokenDto;
import it.bebra.cinema.security.jwt.service.JwtTokenType;
import it.bebra.cinema.security.jwt.service.JwtTokenServiceProvider;
import it.bebra.cinema.security.jwt.port.in.GetNewAccessTokenInputPort;
import it.bebra.cinema.security.jwt.port.out.RefreshTokenOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetNewAccessTokenUseCase implements GetNewAccessTokenInputPort {


    private final JwtTokenServiceProvider jwtTokenServiceProvider;
    private final RefreshTokenOutputPort refreshTokenOutputPort;
    private final UserOutputPort userOutputPort;

    @Override
    public AccessTokenDto invoke(String oldRefreshToken) {
        if (!jwtTokenServiceProvider.isValid(oldRefreshToken, JwtTokenType.REFRESH)) {
            throw JwtAuthenticationException.invalidRefreshToken();
        }

        String username = jwtTokenServiceProvider.extractUsername(oldRefreshToken, JwtTokenType.REFRESH);

        Token savedRefreshToken = refreshTokenOutputPort.findTokenByUserUsername(username)
                .orElseThrow(JwtAuthenticationException::revokedRefreshToken);

        if (!savedRefreshToken.getValue().equals(oldRefreshToken)) {
            throw JwtAuthenticationException.revokedRefreshToken();
        }

        User user = userOutputPort.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException(username));

        Token accessToken = jwtTokenServiceProvider.generateToken(user, JwtTokenType.ACCESS);

        return new AccessTokenDto(accessToken.getValue());
    }
}
