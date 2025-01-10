package it.bebra.cinema.port.out.spring.jpa;

import it.bebra.cinema.application.port.out.UserOutputPort;
import it.bebra.cinema.domain.User;
import it.bebra.cinema.persistence.database.spring.jpa.repository.JpaUserRepository;
import it.bebra.cinema.port.out.spring.jpa.mapper.JpaUserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class JpaUserRepositoryAdapter implements UserOutputPort {
    private final JpaUserRepository jpaUserRepository;

    private final JpaUserMapper userMapper;

    @Override
    public Optional<User> findByUsername(String username) {
        return jpaUserRepository.findByUsernameAndIsDeletedFalse(username)
                .map(userMapper::toDomain);
    }

    @Override
    public boolean existsByUsername(String username) {
        return jpaUserRepository.existsByUsername(username);
    }

    @Override
    public void update(User user) {
        jpaUserRepository.save(userMapper.toEntity(user));
    }

    @Override
    public int create(User user) {
        return jpaUserRepository
                .save(userMapper.toEntity(user))
                .getId();
    }
}
