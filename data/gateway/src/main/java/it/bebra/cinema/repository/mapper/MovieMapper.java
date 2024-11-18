package it.bebra.cinema.repository.mapper;

import it.bebra.cinema.entity.JpaMovie;
import it.bebra.cinema.model.Movie;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface MovieMapper {
    JpaMovie toEntity(Movie domain);

    Movie toDomain(JpaMovie entity);
}
