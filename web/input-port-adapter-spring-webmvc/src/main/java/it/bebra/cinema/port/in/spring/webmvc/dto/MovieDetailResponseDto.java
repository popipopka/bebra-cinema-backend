package it.bebra.cinema.port.in.spring.webmvc.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Schema(description = "Детальная информация о фильме")
@Data
@Builder
public class MovieDetailResponseDto {
    @Schema(description = "Идентификатор фильма", example = "1")
    private int id;

    @Schema(description = "Название фильма", example = "Нефть")
    private String name;

    @Schema(description = "Ссылка на постер фильма", example = "https://example.com/poster.jpg")
    private String posterUrl;

    @Schema(description = "Продолжительность фильма в минутах", example = "120")
    private int duration;

    @Schema(description = "Год выпуска фильма", example = "2007")
    private int year;

    @Schema(description = "Описание фильма", example = "Фильм о нефтяной промышленности и человеческой жадности.")
    private String description;

    @Schema(description = "Список жанров фильма", example = "[\"драма\", \"история\"]")
    private List<String> genres;
}
