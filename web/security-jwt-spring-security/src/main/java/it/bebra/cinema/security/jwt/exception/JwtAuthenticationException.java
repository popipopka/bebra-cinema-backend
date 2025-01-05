package it.bebra.cinema.security.jwt.exception;

public class JwtAuthenticationException extends RuntimeException {
    private static final String REFRESH_TOKEN_IS_INVALID = "Refresh token is invalid";
    private static final String REFRESH_TOKEN_IS_REVOKED = "Refresh token has been revoked";

    private JwtAuthenticationException(String message) {
        super(message);
    }

    public static JwtAuthenticationException invalidRefreshToken() {
        return new JwtAuthenticationException(REFRESH_TOKEN_IS_INVALID);
    }

    public static JwtAuthenticationException revokedRefreshToken() {
        return new JwtAuthenticationException(REFRESH_TOKEN_IS_REVOKED);
    }
}
