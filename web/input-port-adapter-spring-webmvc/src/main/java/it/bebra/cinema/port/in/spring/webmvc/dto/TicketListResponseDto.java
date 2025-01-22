package it.bebra.cinema.port.in.spring.webmvc.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Schema(description = "Краткая информация о билете для списка")
@Data
@Builder
public class TicketListResponseDto {

    @Schema(description = "Идентификатор билета", example = "1")
    private int id;

    @Schema(description = "Ряд в зале", example = "5")
    private int row;

    @Schema(description = "Место в ряду", example = "12")
    private int place;

    @Schema(description = "Цена билета", example = "500.0")
    private float price;

    @Schema(description = "Время начала сеанса", example = "2023-10-15T18:00:00Z")
    private Instant sessionStartTime;

    @Schema(description = "Название фильма", example = "Нефть")
    private String movieName;

    @Schema(description = "Ссылка на постер фильма", example = "https://example.com/poster.jpg")
    private String moviePosterUrl;
}
