package it.bebra.cinema.gateway.mapper;

import it.bebra.cinema.database.entity.JpaAuthority;
import it.bebra.cinema.domain.Authority;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(config = JpaMapperConfig.class)
public interface JpaAuthorityMapper {
    JpaAuthorityMapper INSTANCE = Mappers.getMapper(JpaAuthorityMapper.class);

    JpaAuthority toEntity(Authority domain);

    Authority toDomain(JpaAuthority entity);
}
