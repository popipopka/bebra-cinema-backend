package it.bebra.cinema.port.in.spring.webmvc.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Schema(description = "Краткая информация о фильме для списка")
@Data
@Builder
public class MovieListResponseDto {

    @Schema(description = "Идентификатор фильма", example = "1")
    private int id;

    @Schema(description = "Ссылка на постер фильма", example = "https://example.com/poster.jpg")
    private String posterUrl;

    @Schema(description = "Название фильма", example = "Нефть")
    private String name;

    @Schema(description = "Продолжительность фильма в минутах", example = "120")
    private int duration;
}

