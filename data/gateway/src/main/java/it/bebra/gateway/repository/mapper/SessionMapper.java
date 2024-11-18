package it.bebra.gateway.repository.mapper;

import it.bebra.database.entity.JpaSession;
import it.bebra.domain.model.Session;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(config = MapperConfig.class)
public interface SessionMapper {
    JpaSession toEntity(Session domain);

    Session toDomain(JpaSession entity);
}
