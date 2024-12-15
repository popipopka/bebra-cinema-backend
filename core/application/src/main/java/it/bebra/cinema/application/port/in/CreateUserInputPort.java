package it.bebra.cinema.application.port.in;

import it.bebra.cinema.application.dto.UserCreateRequestDto;

public interface CreateUserInputPort {
    void invoke(UserCreateRequestDto request);
}
