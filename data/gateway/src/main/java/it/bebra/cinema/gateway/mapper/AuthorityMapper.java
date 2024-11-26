package it.bebra.cinema.gateway.mapper;

import it.bebra.cinema.database.entity.JpaAuthority;
import it.bebra.cinema.domain.Authority;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(config = MapperConfig.class)
public interface AuthorityMapper {
    AuthorityMapper INSTANCE = Mappers.getMapper(AuthorityMapper.class);

    JpaAuthority toEntity(Authority domain);

    Authority toDomain(JpaAuthority entity);
}
