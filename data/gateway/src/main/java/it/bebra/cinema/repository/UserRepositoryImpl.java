package it.bebra.cinema.repository;

import it.bebra.cinema.entity.JpaUser;
import it.bebra.cinema.model.User;
import it.bebra.cinema.repository.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import it.bebra.cinema.port.out.UserRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    private final JpaUserRepository jpaUserRepository;
    private final UserMapper userMapper;

    @Override
    public User save(User user) {
        JpaUser jpaUser = userMapper.toEntity(user);

        jpaUser = jpaUserRepository.save(jpaUser);

        return userMapper.toDomain(jpaUser);
    }

    @Override
    public Optional<User> findById(int id) {
        return jpaUserRepository.findById(id)
                .map(userMapper::toDomain);
    }

    @Override
    public List<User> findAll() {
        return jpaUserRepository.findAll().stream()
                .map(userMapper::toDomain)
                .toList();
    }

    @Override
    public void deleteById(int id) {
        jpaUserRepository.deleteById(id);
    }
}
