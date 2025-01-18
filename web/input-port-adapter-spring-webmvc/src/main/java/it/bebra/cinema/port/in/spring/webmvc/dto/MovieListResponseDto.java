package it.bebra.cinema.port.in.spring.webmvc.dto;

import lombok.Data;

@Data
public class MovieListResponseDto {
    private int id;

    private String posterUrl;

    private String name;

    private int duration;
}
