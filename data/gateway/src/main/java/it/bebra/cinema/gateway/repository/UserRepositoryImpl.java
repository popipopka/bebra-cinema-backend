package it.bebra.cinema.gateway.repository;

import it.bebra.cinema.database.repository.JpaUserRepository;
import it.bebra.cinema.domain.User;
import it.bebra.cinema.gateway.mapper.UserMapper;
import it.bebra.cinema.usecase.port.out.UserRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    private final JpaUserRepository jpaUserRepository;
    private final UserMapper userMapper;


    @Override
    public Optional<User> findByUsername(String username) {
        return jpaUserRepository.findByUsername(username)
                .map(userMapper::toDomain);
    }
}
