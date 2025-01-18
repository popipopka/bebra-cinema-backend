package it.bebra.cinema.port.in.spring.webmvc.dto;

import lombok.Data;

import java.time.Instant;

@Data
public class TicketListResponseDto {
    private int id;

    private int row;

    private int place;

    private float price;

    private Instant sessionStartTime;

    private String movieName;

    private String moviePosterUrl;
}
