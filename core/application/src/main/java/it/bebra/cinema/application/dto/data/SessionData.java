package it.bebra.cinema.application.dto.data;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class SessionData {
    private int id;

    private MovieData movie;

    private HallData hall;

    private Instant startTime;

    private float price;
}
