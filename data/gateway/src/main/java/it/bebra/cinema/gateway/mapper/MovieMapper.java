package it.bebra.cinema.gateway.mapper;

import it.bebra.cinema.database.entity.JpaMovie;
import it.bebra.cinema.domain.Movie;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class,
        uses = SessionMapper.class)
public interface MovieMapper {
    JpaMovie toEntity(Movie domain);

    Movie toDomain(JpaMovie entity);
}
