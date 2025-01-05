package it.bebra.cinema.application.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class SessionListResponseDto {
    private int id;

    private String hallName;

    private Instant startTime;

    private float price;
}
