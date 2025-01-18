package it.bebra.cinema.application.port.in.usecase;

import it.bebra.cinema.application.dto.request.UserCreateRequest;
import it.bebra.cinema.application.exception.AuthorityNotFoundException;
import it.bebra.cinema.application.exception.UserAlreadyExistsException;
import it.bebra.cinema.application.mapper.DomainUserMapper;
import it.bebra.cinema.application.port.in.CreateUserInputPort;
import it.bebra.cinema.application.port.out.AuthorityOutputPort;
import it.bebra.cinema.application.port.out.PasswordEncoderOutputPort;
import it.bebra.cinema.application.port.out.UserOutputPort;
import it.bebra.cinema.domain.Authority;
import it.bebra.cinema.domain.User;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateUserUseCase implements CreateUserInputPort {
    private final UserOutputPort userOutputPort;
    private final AuthorityOutputPort authorityOutputPort;

    private final PasswordEncoderOutputPort passwordEncoderOutputPort;

    private final DomainUserMapper userMapper;

    @Override
    public int invoke(UserCreateRequest request) {
        if (userOutputPort.existsByUsername(request.getUsername())) {
            throw new UserAlreadyExistsException(request.getUsername());
        }

        User user = userMapper.toDomain(request);

        Authority authority = authorityOutputPort.findByName("ROLE_USER")
                .orElseThrow(() -> new AuthorityNotFoundException("ROLE_USER"));

        user.addAuthority(authority);
        user.setPassword(passwordEncoderOutputPort.encode(user.getPassword()));

        return userOutputPort.create(user);
    }
}
