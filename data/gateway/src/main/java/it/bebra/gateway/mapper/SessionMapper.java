package it.bebra.gateway.mapper;

import it.bebra.database.entity.JpaSession;
import it.bebra.domain.model.Session;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface SessionMapper {
    JpaSession toEntity(Session domain);

    Session toDomain(JpaSession entity);
}
