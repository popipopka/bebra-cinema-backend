package it.bebra.cinema.repository.mapper;

import it.bebra.cinema.entity.JpaUser;
import it.bebra.cinema.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfig.class)
public interface UserMapper {
    JpaUser toEntity(User domain);

    @Mapping(target = "password", ignore = true)
    User toDomain(JpaUser user);
}
