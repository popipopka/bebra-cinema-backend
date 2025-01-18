package it.bebra.cinema.application.mapper;

import it.bebra.cinema.application.dto.data.SessionData;
import it.bebra.cinema.domain.Session;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(config = DomainMapperConfig.class,
        uses = {DomainMovieMapper.class, DomainHallMapper.class})
public interface DomainSessionMapper {
    DomainSessionMapper INSTANCE = Mappers.getMapper(DomainSessionMapper.class);

    SessionData toData(Session domain);
}
