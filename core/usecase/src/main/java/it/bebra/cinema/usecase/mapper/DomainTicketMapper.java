package it.bebra.cinema.usecase.mapper;

import it.bebra.cinema.domain.Ticket;
import it.bebra.cinema.usecase.dto.TicketListResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(config = DomainMapperConfig.class)
public interface DomainTicketMapper {
    DomainTicketMapper INSTANCE = Mappers.getMapper(DomainTicketMapper.class);

    @Mapping(source = "session.startTime", target = "sessionStartTime")
    @Mapping(source = "session.movie.name", target = "movieName")
    @Mapping(source = "session.movie.posterUrl", target = "moviePosterUrl")
    TicketListResponseDto toListDto(Ticket ticket);
}
