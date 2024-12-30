package it.bebra.cinema.security.jwt.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponseDto {
    private String accessToken;

    private String refreshToken;
}
