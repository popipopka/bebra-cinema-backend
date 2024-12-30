package it.bebra.cinema.port.out.spring.jpa.mapper;

import it.bebra.cinema.persistence.database.spring.jpa.entity.JpaRefreshToken;
import it.bebra.cinema.security.jwt.domain.Token;
import org.mapstruct.Mapper;

@Mapper(config = JpaMapperConfig.class,
        uses = JpaUserMapper.class)
public interface JpaRefreshTokenMapper {
    JpaRefreshToken toEntity(Token model);

    Token toDomain(JpaRefreshToken entity);
}
