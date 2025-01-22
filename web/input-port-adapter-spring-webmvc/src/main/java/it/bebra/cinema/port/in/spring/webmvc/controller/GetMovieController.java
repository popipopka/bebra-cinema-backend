package it.bebra.cinema.port.in.spring.webmvc.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import it.bebra.cinema.application.port.in.GetMovieInputPort;
import it.bebra.cinema.port.in.spring.webmvc.dto.MovieDetailResponseDto;
import it.bebra.cinema.port.in.spring.webmvc.mapper.MovieDataMapper;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Фильмы", description = "Управление фильмами")
@RestController
@RequiredArgsConstructor
public class GetMovieController {
    private final GetMovieInputPort getMovieInputPort;
    private final MovieDataMapper movieDataMapper;

    @Operation(
            summary = "Получить данные фильма",
            description = "Получение данных текущего фильма",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Данные фильма"
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Фильм не найден",
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
                            name = "id",
                            description = "Идентификатор фильма",
                            example = "1"
                    )
            },
            security = @SecurityRequirement(name = "JWT")
    )
    @GetMapping(value = "/api/v1/movies/{id:^\\d+$}", produces = "application/json")
    public ResponseEntity<MovieDetailResponseDto> getMovie(
            @PathVariable @Min(1) int id
    ) {
        var movie = movieDataMapper.toDetailDto(
                getMovieInputPort.invoke(id)
        );

        return ResponseEntity.ok(movie);
    }
}
