package it.bebra.cinema.domain;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public final class Session {
    private Integer id;

    private Movie movie;

    private Hall hall;

    private Instant startTime;

    private float price;
}
