package it.bebra.cinema.port.out.spring.jpa.mapper;

import org.mapstruct.ReportingPolicy;

@org.mapstruct.MapperConfig(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface JpaMapperConfig {
}
