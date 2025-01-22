package it.bebra.cinema.port.in.spring.webmvc.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Schema(description = "Краткая информация о сеансе для списка")
@Data
@Builder
public class SessionListResponseDto {

    @Schema(description = "Идентификатор сеанса", example = "1")
    private int id;

    @Schema(description = "Название зала, где проходит сеанс", example = "Зал 1")
    private String hallName;

    @Schema(description = "Время начала сеанса", example = "2023-10-15T18:00:00Z")
    private Instant startTime;

    @Schema(description = "Цена билета на сеанс", example = "500.0")
    private float price;
}
