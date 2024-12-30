package it.bebra.cinema.port.out.spring.jpa.mapper;

import it.bebra.cinema.persistence.database.spring.jpa.entity.JpaUser;
import it.bebra.cinema.domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(config = JpaMapperConfig.class,
        uses = JpaAuthorityMapper.class)
public interface JpaUserMapper {

    JpaUser toEntity(User domain);

    User toDomain(JpaUser user);
}
