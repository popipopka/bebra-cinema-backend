package it.bebra.cinema.port.in.spring.webmvc.mapper;

import it.bebra.cinema.application.dto.data.MovieData;
import it.bebra.cinema.port.in.spring.webmvc.dto.MovieDetailResponseDto;
import it.bebra.cinema.port.in.spring.webmvc.dto.MovieListResponseDto;
import org.mapstruct.Mapper;

@Mapper(config = DataMapperConfig.class)
public interface MovieDataMapper {
    MovieListResponseDto toListDto(MovieData data);

    MovieDetailResponseDto toDetailDto(MovieData data);
}
