package it.bebra.gateway.mapper;

import it.bebra.database.entity.JpaUser;
import it.bebra.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfig.class)
public interface UserMapper {
    JpaUser toEntity(User domain);

    @Mapping(target = "password", ignore = true)
    User toDomain(JpaUser user);
}
