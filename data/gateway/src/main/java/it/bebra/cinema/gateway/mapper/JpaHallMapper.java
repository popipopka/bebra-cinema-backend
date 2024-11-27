package it.bebra.cinema.gateway.mapper;


import it.bebra.cinema.database.entity.JpaHall;
import it.bebra.cinema.domain.Hall;
import org.mapstruct.Mapper;

@Mapper(config = JpaMapperConfig.class)
public interface JpaHallMapper {
    JpaHall toEntity(Hall domain);

    Hall toDomain(JpaHall entity);
}
