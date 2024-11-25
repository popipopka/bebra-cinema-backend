package it.bebra.cinema.gateway.mapper;

import it.bebra.cinema.database.entity.JpaHall;
import it.bebra.cinema.domain.Hall;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface GatewayHallMapper {
    JpaHall toEntity(Hall domain);

    Hall toDomain(JpaHall entity);
}
