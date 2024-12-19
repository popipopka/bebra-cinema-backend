package it.bebra.cinema.port.out.spring.jpa;

import it.bebra.cinema.application.port.out.UserOutputPort;
import it.bebra.cinema.database.spring.jpa.repository.JpaUserRepository;
import it.bebra.cinema.domain.User;
import it.bebra.cinema.port.out.spring.jpa.mapper.JpaUserMapper;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class JpaUserRepositoryAdapter implements UserOutputPort {
    private final JpaUserRepository jpaUserRepository;

    private final JpaUserMapper userMapper;

    @Override
    public Optional<User> findUserByUsername(String username) {
        return jpaUserRepository.findByUsername(username)
                .map(userMapper::toDomain);
    }

    @Override
    public boolean existsUserByUsername(String username) {
        return jpaUserRepository.existsByUsername(username);
    }

    @Override
    public void createUser(User user) {
        jpaUserRepository.save(userMapper.toEntity(user));
    }
}
