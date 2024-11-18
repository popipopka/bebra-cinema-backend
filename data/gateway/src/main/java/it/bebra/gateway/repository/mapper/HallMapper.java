package it.bebra.gateway.repository.mapper;

import it.bebra.database.entity.JpaHall;
import it.bebra.domain.model.Hall;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(config = MapperConfig.class)
public interface HallMapper {
    JpaHall toEntity(Hall domain);

    Hall toDomain(JpaHall entity);
}
