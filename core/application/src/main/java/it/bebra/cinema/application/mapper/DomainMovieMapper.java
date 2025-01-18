package it.bebra.cinema.application.mapper;

import it.bebra.cinema.application.dto.data.MovieData;
import it.bebra.cinema.domain.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(config = DomainMapperConfig.class,
        uses = DomainGenreMapper.class)
public interface DomainMovieMapper {
    DomainMovieMapper INSTANCE = Mappers.getMapper(DomainMovieMapper.class);

    @Mapping(target = "genres", qualifiedByName = "listGenresToListString")
    MovieData toData(Movie domain);
}
