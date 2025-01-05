package it.bebra.cinema.application.port.in;

import it.bebra.cinema.application.dto.response.UserDetailResponseDto;

public interface GetUserInputPort {
    UserDetailResponseDto invoke(String username);
}
