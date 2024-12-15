package it.bebra.cinema.application.mapper;

import it.bebra.cinema.application.dto.SessionListResponseDto;
import it.bebra.cinema.domain.Session;
import org.mapstruct.Mapper;

@Mapper(config = DomainMapperConfig.class)
public interface DomainSessionMapper {
    SessionListResponseDto toListDto(Session session);
}
