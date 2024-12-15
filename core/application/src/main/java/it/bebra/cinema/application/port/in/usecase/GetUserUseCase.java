package it.bebra.cinema.application.port.in.usecase;

import it.bebra.cinema.application.dto.UserDetailResponseDto;
import it.bebra.cinema.application.exception.UserNotFoundException;
import it.bebra.cinema.application.mapper.DomainUserMapper;
import it.bebra.cinema.application.port.in.GetUserInputPort;
import it.bebra.cinema.application.port.out.UserOutputPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetUserUseCase implements GetUserInputPort {
    private final UserOutputPort userOutputPort;

    private final DomainUserMapper domainUserMapper;

    @Override
    public UserDetailResponseDto invoke(String username) {
        return userOutputPort.findUserByUsername(username)
                .map(domainUserMapper::toDetailDto)
                .orElseThrow(() -> new UserNotFoundException(username));
    }
}
