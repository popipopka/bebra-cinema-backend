package it.bebra.cinema.security.jwt.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TokensData {
    private String accessToken;

    private String refreshToken;
}
