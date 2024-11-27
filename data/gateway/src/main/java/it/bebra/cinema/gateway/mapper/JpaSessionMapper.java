package it.bebra.cinema.gateway.mapper;

import it.bebra.cinema.database.entity.JpaSession;
import it.bebra.cinema.domain.Session;
import org.mapstruct.Mapper;

@Mapper(config = JpaMapperConfig.class,
        uses = {JpaMovieMapper.class, JpaHallMapper.class})
public interface JpaSessionMapper {
    JpaSession toEntity(Session domain);

    Session toDomain(JpaSession entity);
}
