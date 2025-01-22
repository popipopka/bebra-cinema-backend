package it.bebra.cinema.security.jwt.port.in;

public interface GetNewAccessTokenInputPort {

    String invoke(String refreshToken);
}
