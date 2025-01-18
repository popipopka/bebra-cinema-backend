package it.bebra.cinema.port.in.spring.webmvc.controller;

import it.bebra.cinema.port.in.spring.webmvc.dto.SessionListResponseDto;
import it.bebra.cinema.application.port.in.GetAllMovieSessionsInputPort;
import it.bebra.cinema.port.in.spring.webmvc.mapper.SessionDataMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GetAllMovieSessionController {
    private final GetAllMovieSessionsInputPort getAllMovieSessionsInputPort;
    private final SessionDataMapper sessionDataMapper;

    @GetMapping("/api/v1/movies/{movieId:^\\d+$}/sessions")
    public ResponseEntity<List<SessionListResponseDto>> getAllMovieSessions(@PathVariable int movieId) {
        var sessions = getAllMovieSessionsInputPort.invoke(movieId)
                .stream()
                .map(sessionDataMapper::toListDto)
                .toList();

        return sessions.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(sessions);
    }
}
