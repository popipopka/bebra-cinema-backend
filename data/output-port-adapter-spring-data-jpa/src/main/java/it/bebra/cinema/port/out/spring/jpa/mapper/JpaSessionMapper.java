package it.bebra.cinema.port.out.spring.jpa.mapper;

import it.bebra.cinema.persistence.database.spring.jpa.entity.JpaSession;
import it.bebra.cinema.domain.Session;
import org.mapstruct.Mapper;

@Mapper(config = JpaMapperConfig.class,
        uses = {JpaMovieMapper.class, JpaHallMapper.class})
public interface JpaSessionMapper {
    JpaSession toEntity(Session domain);

    Session toDomain(JpaSession entity);
}
