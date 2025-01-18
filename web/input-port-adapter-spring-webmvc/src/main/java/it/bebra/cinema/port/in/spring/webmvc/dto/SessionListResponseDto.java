package it.bebra.cinema.port.in.spring.webmvc.dto;

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
