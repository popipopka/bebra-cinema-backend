package it.bebra.cinema.application.mapper;

import it.bebra.cinema.application.dto.MovieDetailResponseDto;
import it.bebra.cinema.domain.Movie;
import it.bebra.cinema.application.dto.MovieListResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(config = DomainMapperConfig.class)
public interface DomainMovieMapper {
    DomainMovieMapper INSTANCE = Mappers.getMapper(DomainMovieMapper.class);

    MovieListResponseDto toListDto(Movie movie);

    MovieDetailResponseDto toDetailDto(Movie movie);
}
