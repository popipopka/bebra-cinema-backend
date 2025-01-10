package it.bebra.cinema.application.mapper;

import it.bebra.cinema.application.dto.request.UserCreateRequestDto;
import it.bebra.cinema.application.dto.request.UserUpdateRequestDto;
import it.bebra.cinema.application.dto.response.UserDetailResponseDto;
import it.bebra.cinema.domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(config = DomainMapperConfig.class)
public interface DomainUserMapper {
    DomainUserMapper INSTANCE = Mappers.getMapper(DomainUserMapper.class);

    User toDomain(UserCreateRequestDto dto);

    UserDetailResponseDto toDetailDto(User domain);

    @Mapping(target = "id", ignore = true)
    void updateDomain(@MappingTarget User domain, UserUpdateRequestDto payload);
}
