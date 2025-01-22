package it.bebra.cinema.port.in.spring.webmvc.openapi.schema;

import io.swagger.v3.oas.annotations.media.Schema;
import it.bebra.cinema.application.dto.page.MovieKeysetCursors;
import it.bebra.cinema.port.in.spring.webmvc.dto.MovieListResponseDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Schema(description = "Страница с фильмами")
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class KeysetPageMovieListResponseDtoSchema {
    @Schema(description = "Список фильмов")
    private List<MovieListResponseDto> items;

    @Schema(
            description = "Курсоры для keyset пагинации",
            example = """
                    {
                        "lastId": "1"
                    }
                    """
    )
    private Map<String, MovieKeysetCursors> cursors;

    @Schema(description = "Флаг, указывающий, есть ли еще страницы", example = "true")
    private boolean hasMore;
}