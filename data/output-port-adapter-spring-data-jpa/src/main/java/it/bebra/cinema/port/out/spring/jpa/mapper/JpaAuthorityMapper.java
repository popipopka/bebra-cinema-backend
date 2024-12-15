package it.bebra.cinema.port.out.spring.jpa.mapper;

import it.bebra.cinema.database.spring.jpa.entity.JpaAuthority;
import it.bebra.cinema.domain.Authority;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(config = JpaMapperConfig.class)
public interface JpaAuthorityMapper {
    JpaAuthorityMapper INSTANCE = Mappers.getMapper(JpaAuthorityMapper.class);

    Authority toDomain(JpaAuthority entity);
}
