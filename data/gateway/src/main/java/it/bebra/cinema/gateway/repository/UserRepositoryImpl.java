package it.bebra.cinema.gateway.repository;

import it.bebra.cinema.gateway.mapper.GatewayUserMapper;
import it.bebra.cinema.usecase.port.out.UserRepository;
import it.bebra.cinema.database.repository.JpaUserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    private final JpaUserRepository jpaUserRepository;
    private final GatewayUserMapper userMapper;


}
