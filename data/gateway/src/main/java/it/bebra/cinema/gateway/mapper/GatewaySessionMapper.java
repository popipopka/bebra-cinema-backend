package it.bebra.cinema.gateway.mapper;

import it.bebra.cinema.database.entity.JpaSession;
import it.bebra.cinema.domain.Session;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class,
        uses = {GatewayMovieMapper.class, GatewayHallMapper.class})
public interface GatewaySessionMapper {
    JpaSession toEntity(Session domain);

    Session toDomain(JpaSession entity);
}
