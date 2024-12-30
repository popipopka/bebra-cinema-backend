package it.bebra.cinema.port.out.spring.jpa.mapper;

import it.bebra.cinema.domain.Authority;
import it.bebra.cinema.persistence.database.spring.jpa.entity.JpaAuthority;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(config = JpaMapperConfig.class)
public interface JpaAuthorityMapper {

    Authority toDomain(JpaAuthority entity);
}
