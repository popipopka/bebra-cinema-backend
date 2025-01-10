package it.bebra.cinema.application.port.in;

import it.bebra.cinema.application.dto.request.UserUpdateRequestDto;

public interface UpdateUserInputPort {
    void invoke(String username, UserUpdateRequestDto request);
}
