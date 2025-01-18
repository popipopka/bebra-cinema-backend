package it.bebra.cinema.port.in.spring.webmvc.mapper;

import it.bebra.cinema.application.dto.data.UserData;
import it.bebra.cinema.port.in.spring.webmvc.dto.UserDetailResponseDto;
import org.mapstruct.Mapper;

@Mapper(config = DataMapperConfig.class)
public interface UserDataMapper {

    UserDetailResponseDto toDetailDto(UserData data);
}
