package it.bebra.cinema.application.mapper;

import it.bebra.cinema.application.dto.response.SessionListResponseDto;
import it.bebra.cinema.domain.Session;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(config = DomainMapperConfig.class)
public interface DomainSessionMapper {
    DomainSessionMapper INSTANCE = Mappers.getMapper(DomainSessionMapper.class);

    @Mapping(source = "hall.name", target = "hallName")
    SessionListResponseDto toListDto(Session domain);
}
