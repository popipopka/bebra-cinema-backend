package it.bebra.gateway.repository.mapper;

import it.bebra.database.entity.JpaUser;
import it.bebra.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(config = MapperConfig.class)
public interface UserMapper {
    JpaUser toEntity(User domain);

    @Mapping(target = "password", ignore = true)
    User toDomain(JpaUser user);
}
