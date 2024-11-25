package it.bebra.cinema.gateway.mapper;

import it.bebra.cinema.database.entity.JpaTicket;
import it.bebra.cinema.domain.Ticket;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(config = MapperConfig.class,
        uses = GatewaySessionMapper.class)
public interface GatewayTicketMapper {
    GatewayTicketMapper INSTANCE = Mappers.getMapper(GatewayTicketMapper.class);

    JpaTicket toEntity(Ticket domain);

    Ticket toDomain(JpaTicket entity);
}
