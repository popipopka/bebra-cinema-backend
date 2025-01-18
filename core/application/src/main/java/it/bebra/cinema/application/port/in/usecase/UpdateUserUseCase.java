package it.bebra.cinema.application.port.in.usecase;

import it.bebra.cinema.application.dto.request.UserUpdateRequest;
import it.bebra.cinema.application.exception.UserNotFoundException;
import it.bebra.cinema.application.mapper.DomainUserMapper;
import it.bebra.cinema.application.port.in.UpdateUserInputPort;
import it.bebra.cinema.application.port.out.UserOutputPort;
import it.bebra.cinema.domain.User;
import lombok.RequiredArgsConstructor;

import java.time.Instant;

@RequiredArgsConstructor
public class UpdateUserUseCase implements UpdateUserInputPort {
    private final UserOutputPort userOutputPort;
    private final DomainUserMapper domainUserMapper;

    @Override
    public void invoke(String username, UserUpdateRequest payload) {
        User user = userOutputPort.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException(username));

        domainUserMapper.updateDomain(user, payload);

        user.setUpdatedTime(Instant.now());

        userOutputPort.update(user);
    }
}
