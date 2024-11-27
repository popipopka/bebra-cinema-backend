package it.bebra.cinema.gateway.mapper;

import it.bebra.cinema.database.entity.JpaTicket;
import it.bebra.cinema.domain.Ticket;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(config = JpaMapperConfig.class,
        uses = JpaSessionMapper.class)
public interface JpaTicketMapper {
    JpaTicketMapper INSTANCE = Mappers.getMapper(JpaTicketMapper.class);

    JpaTicket toEntity(Ticket domain);

    Ticket toDomain(JpaTicket entity);
}
