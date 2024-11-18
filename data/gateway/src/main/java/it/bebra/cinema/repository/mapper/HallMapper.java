package it.bebra.cinema.repository.mapper;

import it.bebra.cinema.entity.JpaHall;
import it.bebra.cinema.model.Hall;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface HallMapper {
    JpaHall toEntity(Hall domain);

    Hall toDomain(JpaHall entity);
}
