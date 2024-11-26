package it.bebra.cinema.gateway.mapper;

import it.bebra.cinema.database.entity.JpaSession;
import it.bebra.cinema.domain.Session;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class,
        uses = {MovieMapper.class, HallMapper.class})
public interface SessionMapper {
    JpaSession toEntity(Session domain);

    Session toDomain(JpaSession entity);
}
