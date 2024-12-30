package it.bebra.cinema.port.out.spring.jpa.mapper;

import it.bebra.cinema.persistence.database.spring.jpa.entity.JpaMovie;
import it.bebra.cinema.domain.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(config = JpaMapperConfig.class,
        uses = JpaSessionMapper.class)
public interface JpaMovieMapper {

    Movie toDomain(JpaMovie entity);
}
