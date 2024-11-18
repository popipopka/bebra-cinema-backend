package it.bebra.cinema.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public final class Session {
    private Integer id;

    private Movie movie;

    private Hall hall;

    private LocalDateTime startTime;

    private float price;
}
