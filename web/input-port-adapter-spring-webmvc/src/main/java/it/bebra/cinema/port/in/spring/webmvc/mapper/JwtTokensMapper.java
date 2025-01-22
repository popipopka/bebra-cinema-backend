package it.bebra.cinema.port.in.spring.webmvc.mapper;

import it.bebra.cinema.port.in.spring.webmvc.dto.LoginResponseDto;
import it.bebra.cinema.security.jwt.dto.TokensData;
import org.mapstruct.Mapper;

@Mapper(config = DataMapperConfig.class)
public interface JwtTokensMapper {
    LoginResponseDto toDto(TokensData data);
}
