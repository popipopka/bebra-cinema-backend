package it.bebra.cinema.port.out.spring.jpa.mapper;

import it.bebra.cinema.domain.Movie;
import it.bebra.cinema.persistence.database.spring.jpa.entity.JpaMovie;
import org.mapstruct.Mapper;

@Mapper(config = JpaMapperConfig.class,
        uses = {JpaSessionMapper.class, JpaGenreMapper.class})
public interface JpaMovieMapper {

    Movie toDomain(JpaMovie entity);
}
