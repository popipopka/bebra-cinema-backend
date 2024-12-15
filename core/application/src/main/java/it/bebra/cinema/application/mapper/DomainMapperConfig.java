package it.bebra.cinema.application.mapper;

import org.mapstruct.ReportingPolicy;

@org.mapstruct.MapperConfig(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DomainMapperConfig {
}
