package it.bebra.cinema.application.mapper;

import it.bebra.cinema.application.dto.data.UserData;
import it.bebra.cinema.application.dto.request.UserCreateRequest;
import it.bebra.cinema.application.dto.request.UserUpdateRequest;
import it.bebra.cinema.domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(config = DomainMapperConfig.class,
        uses = DomainAuthorityMapper.class)
public interface DomainUserMapper {
    DomainUserMapper INSTANCE = Mappers.getMapper(DomainUserMapper.class);

    User toDomain(UserCreateRequest dto);

    void updateDomain(@MappingTarget User domain, UserUpdateRequest payload);

    @Mapping(target = "authorities", qualifiedByName = "setAuthoritiesToListString")
    UserData toData(User domain);
}
