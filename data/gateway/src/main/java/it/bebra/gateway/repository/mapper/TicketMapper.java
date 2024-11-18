package it.bebra.gateway.repository.mapper;

import it.bebra.database.entity.JpaTicket;
import it.bebra.domain.model.Ticket;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(config = MapperConfig.class)
public interface TicketMapper {
    JpaTicket toEntity(Ticket domain);

    Ticket toDomain(JpaTicket entity);
}
