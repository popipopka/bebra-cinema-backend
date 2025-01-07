package it.bebra.cinema.application.mapper;

import it.bebra.cinema.domain.Genre;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper(config = DomainMapperConfig.class)
public interface DomainGenreMapper {

    @Named("listGenresToListString")
    default List<String> toListStrings(List<Genre> genres) {
        return genres.stream()
                .map(Genre::getName)
                .toList();
    }
}
