package it.bebra.cinema.port.in.spring.webmvc.mapper;

import it.bebra.cinema.application.dto.data.TicketData;
import it.bebra.cinema.port.in.spring.webmvc.dto.TicketListResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = DataMapperConfig.class)
public interface TicketDataMapper {

    @Mapping(source = "session.startTime", target = "sessionStartTime")
    @Mapping(source = "session.movie.name", target = "movieName")
    @Mapping(source = "session.movie.posterUrl", target = "moviePosterUrl")
    TicketListResponseDto toListDto(TicketData data);
}
