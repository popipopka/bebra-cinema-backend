package it.bebra.cinema.port.out.spring.jpa.mapper;

import it.bebra.cinema.database.spring.jpa.entity.JpaUser;
import it.bebra.cinema.domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(config = JpaMapperConfig.class,
        uses = JpaAuthorityMapper.class)
public interface JpaUserMapper {
    JpaUserMapper INSTANCE = Mappers.getMapper(JpaUserMapper.class);

    JpaUser toEntity(User domain);

    User toDomain(JpaUser user);
}
