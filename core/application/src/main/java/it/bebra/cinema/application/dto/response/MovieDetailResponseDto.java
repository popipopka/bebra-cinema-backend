package it.bebra.cinema.application.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MovieDetailResponseDto {
    private int id;

    private String name;

    private String posterUrl;

    private int duration;

    private int year;

    private String description;
}
