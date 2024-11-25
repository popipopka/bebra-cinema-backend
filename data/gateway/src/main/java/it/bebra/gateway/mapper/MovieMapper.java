package it.bebra.gateway.mapper;

import it.bebra.database.entity.JpaMovie;
import it.bebra.domain.model.Movie;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface MovieMapper {
    JpaMovie toEntity(Movie domain);

    Movie toDomain(JpaMovie entity);
}
