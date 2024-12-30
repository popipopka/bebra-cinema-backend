package it.bebra.cinema.port.out.spring.jpa.mapper;

import it.bebra.cinema.persistence.database.spring.jpa.entity.JpaTicket;
import it.bebra.cinema.domain.Ticket;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(config = JpaMapperConfig.class,
        uses = JpaSessionMapper.class)
public interface JpaTicketMapper {

    JpaTicket toEntity(Ticket domain);

    Ticket toDomain(JpaTicket entity);
}
