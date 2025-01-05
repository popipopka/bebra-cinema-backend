package it.bebra.cinema.application.port.in;

import it.bebra.cinema.application.dto.request.UserCreateRequestDto;

public interface CreateUserInputPort {
    int invoke(UserCreateRequestDto request);
}
