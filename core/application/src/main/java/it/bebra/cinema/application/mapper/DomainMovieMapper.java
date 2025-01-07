package it.bebra.cinema.application.mapper;

import it.bebra.cinema.application.dto.response.MovieDetailResponseDto;
import it.bebra.cinema.domain.Movie;
import it.bebra.cinema.application.dto.response.MovieListResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(config = DomainMapperConfig.class,
        uses = DomainGenreMapper.class)
public interface DomainMovieMapper {
    DomainMovieMapper INSTANCE = Mappers.getMapper(DomainMovieMapper.class);

    MovieListResponseDto toListDto(Movie domain);

    @Mapping(target = "genres", qualifiedByName = "listGenresToListString")
    MovieDetailResponseDto toDetailDto(Movie domain);
}
