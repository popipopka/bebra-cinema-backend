package it.bebra.cinema.repository.mapper;

import it.bebra.cinema.entity.JpaSession;
import it.bebra.cinema.model.Session;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface SessionMapper {
    JpaSession toEntity(Session domain);

    Session toDomain(JpaSession entity);
}
