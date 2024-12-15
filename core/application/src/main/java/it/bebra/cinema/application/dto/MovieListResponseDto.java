package it.bebra.cinema.application.dto;

import lombok.Data;

@Data
public class MovieListResponseDto {
    private int id;

    private String posterUrl;

    private String name;

    private int duration;
}
