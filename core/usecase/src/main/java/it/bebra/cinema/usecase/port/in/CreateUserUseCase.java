package it.bebra.cinema.usecase.port.in;

import it.bebra.cinema.usecase.dto.UserCreateRequestDto;

public interface CreateUserUseCase {
    void invoke(UserCreateRequestDto request);
}
