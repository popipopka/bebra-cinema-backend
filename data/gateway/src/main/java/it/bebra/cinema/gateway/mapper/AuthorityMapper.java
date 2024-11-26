package it.bebra.cinema.gateway.mapper;

import it.bebra.cinema.database.entity.JpaAuthority;
import it.bebra.cinema.domain.Authority;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface AuthorityMapper {
    JpaAuthority toEntity(Authority domain);

    Authority toDomain(JpaAuthority entity);
}
