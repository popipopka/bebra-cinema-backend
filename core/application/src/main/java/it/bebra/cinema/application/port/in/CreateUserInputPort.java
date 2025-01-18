package it.bebra.cinema.application.port.in;

import it.bebra.cinema.application.dto.request.UserCreateRequest;

public interface CreateUserInputPort {
    int invoke(UserCreateRequest request);
}
