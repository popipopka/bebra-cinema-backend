package it.bebra.cinema.application.mapper;

import it.bebra.cinema.application.dto.data.TicketData;
import it.bebra.cinema.domain.Ticket;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(config = DomainMapperConfig.class,
        uses = {DomainSessionMapper.class, DomainUserMapper.class})
public interface DomainTicketMapper {
    DomainTicketMapper INSTANCE = Mappers.getMapper(DomainTicketMapper.class);

    TicketData toData(Ticket domain);
}
