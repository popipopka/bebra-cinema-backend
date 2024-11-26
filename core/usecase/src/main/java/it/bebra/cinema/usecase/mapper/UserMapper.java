package it.bebra.cinema.usecase.mapper;

import it.bebra.cinema.domain.User;
import it.bebra.cinema.usecase.dto.UserCreateRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(config = MapperConfig.class)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toDomain(UserCreateRequestDto dto);
}
