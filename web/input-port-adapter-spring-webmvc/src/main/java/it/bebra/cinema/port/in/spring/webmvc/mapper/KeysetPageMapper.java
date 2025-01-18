package it.bebra.cinema.port.in.spring.webmvc.mapper;

import it.bebra.cinema.application.dto.data.MovieData;
import it.bebra.cinema.application.dto.data.TicketData;
import it.bebra.cinema.application.dto.page.KeysetPage;
import it.bebra.cinema.port.in.spring.webmvc.dto.MovieListResponseDto;
import it.bebra.cinema.port.in.spring.webmvc.dto.TicketListResponseDto;
import org.mapstruct.Mapper;

@Mapper(config = DataMapperConfig.class,
        uses = {MovieDataMapper.class, TicketDataMapper.class})
public interface KeysetPageMapper {
    KeysetPage<MovieListResponseDto> toMoviePage(KeysetPage<MovieData> page);

    KeysetPage<TicketListResponseDto> toTicketPage(KeysetPage<TicketData> page);
}
