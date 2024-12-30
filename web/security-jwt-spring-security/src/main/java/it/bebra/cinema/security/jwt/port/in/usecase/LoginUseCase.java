package it.bebra.cinema.security.jwt.port.in.usecase;

import it.bebra.cinema.application.exception.UserNotFoundException;
import it.bebra.cinema.application.port.out.UserOutputPort;
import it.bebra.cinema.domain.User;
import it.bebra.cinema.security.jwt.domain.Token;
import it.bebra.cinema.security.jwt.dto.LoginRequestDto;
import it.bebra.cinema.security.jwt.dto.LoginResponseDto;
import it.bebra.cinema.security.jwt.service.JwtTokenType;
import it.bebra.cinema.security.jwt.service.JwtTokenServiceProvider;
import it.bebra.cinema.security.jwt.port.in.LoginInputPort;
import it.bebra.cinema.security.jwt.port.out.RefreshTokenOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class LoginUseCase implements LoginInputPort {
    private static final String WRONG_PASSWORD = "Wrong password";

    private final UserOutputPort userOutputPort;
    private final PasswordEncoder passwordEncoder;
    private final RefreshTokenOutputPort refreshTokenOutputPort;
    private final JwtTokenServiceProvider jwtTokenServiceProvider;

    @Override
    public LoginResponseDto invoke(LoginRequestDto loginRequestDto) {
        String username = loginRequestDto.getUsername();

        User user = userOutputPort.findUserByUsername(username)
                .orElseThrow(() -> new UserNotFoundException(username));

        if (!passwordEncoder.matches(loginRequestDto.getPassword(), user.getPassword())) {
            throw new BadCredentialsException(WRONG_PASSWORD);
        }

        Token newRefreshToken = jwtTokenServiceProvider.generateToken(user, JwtTokenType.REFRESH);

        Optional<Token> savedRefreshToken = refreshTokenOutputPort.findTokenByUserUsername(username);
        savedRefreshToken.ifPresent(saved -> newRefreshToken.setId(saved.getId()));

        refreshTokenOutputPort.save(newRefreshToken);

        Token accessToken = jwtTokenServiceProvider.generateToken(user, JwtTokenType.ACCESS);

        return LoginResponseDto.builder()
                .accessToken(accessToken.getValue())
                .refreshToken(newRefreshToken.getValue())
                .build();
    }
}
