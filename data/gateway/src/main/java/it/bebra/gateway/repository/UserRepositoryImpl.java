package it.bebra.gateway.repository;

import it.bebra.usecase.port.out.UserRepository;
import it.bebra.database.repository.JpaUserRepository;
import it.bebra.gateway.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    private final JpaUserRepository jpaUserRepository;
    private final UserMapper userMapper;


}
