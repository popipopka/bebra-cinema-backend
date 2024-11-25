package it.bebra.gateway.mapper;

import it.bebra.database.entity.JpaTicket;
import it.bebra.domain.model.Ticket;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface TicketMapper {
    JpaTicket toEntity(Ticket domain);

    Ticket toDomain(JpaTicket entity);
}
