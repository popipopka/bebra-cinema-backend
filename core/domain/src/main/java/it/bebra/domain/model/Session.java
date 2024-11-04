package it.bebra.domain.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@Builder
public final class Session {
    private Integer id;

    private Movie movie;

    private Hall hall;

    private LocalDateTime startTime;

    private float price;
}
