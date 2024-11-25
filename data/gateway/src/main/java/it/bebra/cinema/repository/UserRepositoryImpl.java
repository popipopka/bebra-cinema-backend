package it.bebra.cinema.repository;

import it.bebra.cinema.port.out.UserRepository;
import it.bebra.cinema.repository.mapper.UserMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    private final JpaUserRepository jpaUserRepository;
    private final UserMapper userMapper;


}
