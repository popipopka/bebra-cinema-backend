package it.bebra.gateway.repository.mapper;

import it.bebra.database.entity.JpaMovie;
import it.bebra.domain.model.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(config = MapperConfig.class)
public interface MovieMapper {
    JpaMovie toEntity(Movie domain);

    Movie toDomain(JpaMovie entity);
}
