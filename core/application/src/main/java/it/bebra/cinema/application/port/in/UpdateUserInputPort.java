package it.bebra.cinema.application.port.in;

import it.bebra.cinema.application.dto.request.UserUpdateRequest;

public interface UpdateUserInputPort {
    void invoke(String username, UserUpdateRequest request);
}
