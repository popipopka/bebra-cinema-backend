package it.bebra.gateway.mapper;

import it.bebra.database.entity.JpaHall;
import it.bebra.domain.model.Hall;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface HallMapper {
    JpaHall toEntity(Hall domain);

    Hall toDomain(JpaHall entity);
}
