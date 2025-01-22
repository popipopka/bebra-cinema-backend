package it.bebra.cinema.port.in.spring.webmvc.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import it.bebra.cinema.application.port.in.GetAllMovieSessionsInputPort;
import it.bebra.cinema.port.in.spring.webmvc.dto.SessionListResponseDto;
import it.bebra.cinema.port.in.spring.webmvc.mapper.SessionDataMapper;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Сеансы", description = "Управление сеансами")
@RestController
@RequiredArgsConstructor
@Validated
public class GetAllMovieSessionController {
    private final GetAllMovieSessionsInputPort getAllMovieSessionsInputPort;
    private final SessionDataMapper sessionDataMapper;

    @Operation(
            summary = "Получить сеансы фильма",
            description = "Получение всех сеансов фильма по его идентификатору",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Список сеансов"
                    ),
                    @ApiResponse(
                            responseCode = "204",
                            description = "Сеансов нет",
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
                            name = "movieId",
                            description = "Идентификатор фильма",
                            example = "1"
                    )
            },
            security = @SecurityRequirement(name = "JWT")
    )
    @GetMapping(value = "/api/v1/movies/{movieId:^\\d+$}/sessions", produces = "application/json")
    public ResponseEntity<List<SessionListResponseDto>> getAllMovieSessions(
            @PathVariable @Min(1) int movieId
    ) {
        var sessions = getAllMovieSessionsInputPort.invoke(movieId)
                .stream()
                .map(sessionDataMapper::toListDto)
                .toList();

        return sessions.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(sessions);
    }
}
