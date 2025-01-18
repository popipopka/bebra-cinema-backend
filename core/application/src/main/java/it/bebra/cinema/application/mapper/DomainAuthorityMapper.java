package it.bebra.cinema.application.mapper;

import it.bebra.cinema.domain.Authority;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;
import java.util.Set;

@Mapper(config = DomainMapperConfig.class)
public interface DomainAuthorityMapper {

    @Named("setAuthoritiesToListString")
    default List<String> toListString(Set<Authority> authorities) {
        return authorities.stream()
                .map(Authority::getName)
                .toList();
    }
}
