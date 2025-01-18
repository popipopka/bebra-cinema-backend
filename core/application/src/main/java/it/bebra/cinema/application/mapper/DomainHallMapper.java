package it.bebra.cinema.application.mapper;

import it.bebra.cinema.application.dto.data.HallData;
import it.bebra.cinema.domain.Hall;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(config = DomainMapperConfig.class)
public interface DomainHallMapper {
    DomainHallMapper INSTANCE = Mappers.getMapper(DomainHallMapper.class);

    HallData toData(Hall domain);
}
