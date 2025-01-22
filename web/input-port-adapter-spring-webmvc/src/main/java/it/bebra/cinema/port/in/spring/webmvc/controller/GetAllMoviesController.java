package it.bebra.cinema.port.in.spring.webmvc.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import it.bebra.cinema.application.dto.page.KeysetPage;
import it.bebra.cinema.application.port.in.GetAllMoviesInputPort;
import it.bebra.cinema.port.in.spring.webmvc.dto.MovieListResponseDto;
import it.bebra.cinema.port.in.spring.webmvc.mapper.KeysetPageMapper;
import it.bebra.cinema.port.in.spring.webmvc.openapi.schema.KeysetPageMovieListResponseDtoSchema;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Фильмы", description = "Управление фильмами")
@RestController
@RequiredArgsConstructor
public class GetAllMoviesController {
    private final GetAllMoviesInputPort getAllMoviesInputPort;
    private final KeysetPageMapper keysetPageMapper;

    @Operation(
            summary = "Постранично получить фильмы",
            description = "Постраничное получение фильмов с поиском по названию",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Список фильмов",
                            content = @Content(
                                    schema = @Schema(
                                            implementation = KeysetPageMovieListResponseDtoSchema.class
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "204",
                            description = "Фильмов нет",
                            content = @Content
                    ),
                    @ApiResponse(
                            responseCode = "401",
                            description = "Пользователь не авторизирован",
                            content = @Content
                    )
            },
            parameters = {
                    @Parameter(
                            name = "lastId",
                            description = "Идентификатор последнего фильма в странице",
                            example = "1"
                    ),
                    @Parameter(
                            name = "limit",
                            description = "Кол-во фильмов на странице",
                            example = "10"
                    ),
                    @Parameter(
                            name = "query",
                            description = "Запрос для поиска фильмов по названию",
                            example = "Нефть"
                    )
            },
            security = @SecurityRequirement(name = "JWT")
    )
    @GetMapping(value = "/api/v1/movies", produces = "application/json")
    public ResponseEntity<KeysetPage<MovieListResponseDto>> getAllMovies(
            @RequestParam(required = false) @Min(1) Integer lastId,
            @RequestParam(required = false, defaultValue = "20") @Min(1) int limit,
            @RequestParam(required = false, defaultValue = "") String query
    ) {
        var moviePage = keysetPageMapper.toMoviePage(
                getAllMoviesInputPort.invoke(lastId, limit, query)
        );

        return moviePage.getItems().isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(moviePage);
    }
}
