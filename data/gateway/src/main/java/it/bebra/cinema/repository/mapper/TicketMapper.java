package it.bebra.cinema.repository.mapper;

import it.bebra.cinema.entity.JpaTicket;
import it.bebra.cinema.model.Ticket;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface TicketMapper {
    JpaTicket toEntity(Ticket domain);

    Ticket toDomain(JpaTicket entity);
}
