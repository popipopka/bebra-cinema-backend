package it.bebra.cinema.gateway.mapper;

import it.bebra.cinema.database.entity.JpaMovie;
import it.bebra.cinema.domain.Movie;
import org.mapstruct.Mapper;

@Mapper(config = JpaMapperConfig.class,
        uses = JpaSessionMapper.class)
public interface JpaMovieMapper {
    JpaMovie toEntity(Movie domain);

    Movie toDomain(JpaMovie entity);
}
