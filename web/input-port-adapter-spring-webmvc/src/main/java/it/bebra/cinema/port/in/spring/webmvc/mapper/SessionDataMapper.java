package it.bebra.cinema.port.in.spring.webmvc.mapper;

import it.bebra.cinema.application.dto.data.SessionData;
import it.bebra.cinema.port.in.spring.webmvc.dto.SessionListResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = DataMapperConfig.class)
public interface SessionDataMapper {

    @Mapping(source = "hall.name", target = "hallName")
    SessionListResponseDto toListDto(SessionData data);
}
