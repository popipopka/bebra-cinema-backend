package it.bebra.cinema.gateway.mapper;

import it.bebra.cinema.database.entity.JpaUser;
import it.bebra.cinema.domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(config = MapperConfig.class,
        uses = AuthorityMapper.class)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    JpaUser toEntity(User domain);

    User toDomain(JpaUser user);
}
