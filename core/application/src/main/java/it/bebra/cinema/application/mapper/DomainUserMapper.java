package it.bebra.cinema.application.mapper;

import it.bebra.cinema.application.dto.UserDetailResponseDto;
import it.bebra.cinema.domain.User;
import it.bebra.cinema.application.dto.UserCreateRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(config = DomainMapperConfig.class)
public interface DomainUserMapper {
    DomainUserMapper INSTANCE = Mappers.getMapper(DomainUserMapper.class);

    User toDomain(UserCreateRequestDto dto);

    UserDetailResponseDto toDetailDto(User user);
}
