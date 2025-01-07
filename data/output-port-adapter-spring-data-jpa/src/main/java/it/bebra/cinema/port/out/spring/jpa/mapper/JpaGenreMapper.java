package it.bebra.cinema.port.out.spring.jpa.mapper;

import it.bebra.cinema.domain.Genre;
import it.bebra.cinema.persistence.database.spring.jpa.entity.JpaGenre;
import org.mapstruct.Mapper;

@Mapper(config = JpaMapperConfig.class)
public interface JpaGenreMapper {
    Genre toDomain(JpaGenre entity);
}
