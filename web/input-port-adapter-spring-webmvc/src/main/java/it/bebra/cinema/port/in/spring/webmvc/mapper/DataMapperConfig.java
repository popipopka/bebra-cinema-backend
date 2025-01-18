package it.bebra.cinema.port.in.spring.webmvc.mapper;

import org.mapstruct.MapperConfig;
import org.mapstruct.ReportingPolicy;

@MapperConfig(unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = "spring")
interface DataMapperConfig {
}
