package it.bebra.cinema.gateway.mapper;

import it.bebra.cinema.database.entity.JpaMovie;
import it.bebra.cinema.domain.Movie;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class,
        uses = GatewaySessionMapper.class)
public interface GatewayMovieMapper {
    JpaMovie toEntity(Movie domain);

    Movie toDomain(JpaMovie entity);
}
