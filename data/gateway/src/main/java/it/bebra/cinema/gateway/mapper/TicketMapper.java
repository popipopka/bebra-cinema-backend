package it.bebra.cinema.gateway.mapper;

import it.bebra.cinema.database.entity.JpaTicket;
import it.bebra.cinema.domain.Ticket;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(config = MapperConfig.class,
        uses = SessionMapper.class)
public interface TicketMapper {
    TicketMapper INSTANCE = Mappers.getMapper(TicketMapper.class);

    JpaTicket toEntity(Ticket domain);

    Ticket toDomain(JpaTicket entity);
}
