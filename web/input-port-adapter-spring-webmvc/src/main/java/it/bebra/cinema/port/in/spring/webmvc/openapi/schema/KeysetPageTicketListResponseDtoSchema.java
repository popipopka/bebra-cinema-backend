package it.bebra.cinema.port.in.spring.webmvc.openapi.schema;

import io.swagger.v3.oas.annotations.media.Schema;
import it.bebra.cinema.application.dto.page.MovieKeysetCursors;
import it.bebra.cinema.port.in.spring.webmvc.dto.TicketListResponseDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Schema(description = "Страница с билетами")
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class KeysetPageTicketListResponseDtoSchema {
    @Schema(description = "Список билетов")
    private List<TicketListResponseDto> items;

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