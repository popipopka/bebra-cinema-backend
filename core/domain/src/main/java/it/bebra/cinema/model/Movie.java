package it.bebra.cinema.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public final class Movie {
    private Integer id;

    private String name;

    private String posterUrl;

    private int duration;

    private int year;

    private String description;

    private List<Genre> genres;
}
