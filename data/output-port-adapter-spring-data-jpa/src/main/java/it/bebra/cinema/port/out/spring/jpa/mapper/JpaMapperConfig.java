package it.bebra.cinema.port.out.spring.jpa.mapper;

import org.mapstruct.ReportingPolicy;

@org.mapstruct.MapperConfig(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = "spring")
public interface JpaMapperConfig {
}
