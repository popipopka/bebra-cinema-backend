package it.bebra.cinema.application.port.in;

import it.bebra.cinema.application.dto.data.UserData;

public interface GetUserInputPort {
    UserData invoke(String username);
}
