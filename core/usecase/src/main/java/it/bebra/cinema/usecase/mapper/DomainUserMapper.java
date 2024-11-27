package it.bebra.cinema.usecase.mapper;

import it.bebra.cinema.domain.User;
import it.bebra.cinema.usecase.dto.UserCreateRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(config = DomainMapperConfig.class)
public interface DomainUserMapper {
    DomainUserMapper INSTANCE = Mappers.getMapper(DomainUserMapper.class);

    User toDomain(UserCreateRequestDto dto);
}
