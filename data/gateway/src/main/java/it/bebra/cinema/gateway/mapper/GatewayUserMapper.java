package it.bebra.cinema.gateway.mapper;

import it.bebra.cinema.database.entity.JpaUser;
import it.bebra.cinema.domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfig.class)
public interface GatewayUserMapper {
    JpaUser toEntity(User domain);

    @Mapping(target = "password", ignore = true)
    User toDomain(JpaUser user);
}
