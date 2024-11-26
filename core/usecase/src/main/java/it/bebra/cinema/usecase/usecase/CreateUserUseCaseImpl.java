package it.bebra.cinema.usecase.usecase;

import it.bebra.cinema.domain.Authority;
import it.bebra.cinema.domain.User;
import it.bebra.cinema.usecase.dto.UserCreateRequestDto;
import it.bebra.cinema.usecase.exception.AlreadyExistsException;
import it.bebra.cinema.usecase.exception.NotFoundException;
import it.bebra.cinema.usecase.mapper.UserMapper;
import it.bebra.cinema.usecase.port.in.CreateUserUseCase;
import it.bebra.cinema.usecase.port.out.AuthorityRepository;
import it.bebra.cinema.usecase.port.out.UserRepository;
import it.bebra.cinema.usecase.util.PasswordEncoder;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateUserUseCaseImpl implements CreateUserUseCase {
    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;

    private final PasswordEncoder passwordEncoder;

    private final UserMapper userMapper;

    @Override
    public void invoke(UserCreateRequestDto request) {
        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new AlreadyExistsException("User with username %s already exists".formatted(request.getUsername()));
        }

        User user = userMapper.toDomain(request);

        Authority authority = authorityRepository.findByName("ROLE_USER")
                .orElseThrow(() -> new NotFoundException("Authority with name ROLE_USER not found"));

        user.addAuthority(authority);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.save(user);
    }
}
