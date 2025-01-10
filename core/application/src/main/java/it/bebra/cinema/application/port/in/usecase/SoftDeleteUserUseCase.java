package it.bebra.cinema.application.port.in.usecase;

import it.bebra.cinema.application.exception.UserNotFoundException;
import it.bebra.cinema.application.port.in.SoftDeleteUserInputPort;
import it.bebra.cinema.application.port.out.UserOutputPort;
import it.bebra.cinema.domain.User;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SoftDeleteUserUseCase implements SoftDeleteUserInputPort {
    private final UserOutputPort userOutputPort;

    @Override
    public void invoke(String username) {
        User user = userOutputPort.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException(username));

        user.setIsDeleted(true);

        userOutputPort.update(user);
    }
}
