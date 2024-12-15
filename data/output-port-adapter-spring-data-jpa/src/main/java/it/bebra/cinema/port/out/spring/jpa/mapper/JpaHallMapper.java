package it.bebra.cinema.port.out.spring.jpa.mapper;


import it.bebra.cinema.database.spring.jpa.entity.JpaHall;
import it.bebra.cinema.domain.Hall;
import org.mapstruct.Mapper;

@Mapper(config = JpaMapperConfig.class)
public interface JpaHallMapper {
    JpaHall toEntity(Hall domain);

    Hall toDomain(JpaHall entity);
}
