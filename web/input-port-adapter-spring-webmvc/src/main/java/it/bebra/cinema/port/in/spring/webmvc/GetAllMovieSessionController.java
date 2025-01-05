package it.bebra.cinema.port.in.spring.webmvc;

import it.bebra.cinema.application.dto.response.SessionListResponseDto;
import it.bebra.cinema.application.port.in.GetAllMovieSessionsInputPort;
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

    @GetMapping("/api/v1/movies/{movieId:^\\d+$}/sessions")
    public ResponseEntity<List<SessionListResponseDto>> getAllMovieSessions(@PathVariable int movieId) {
        var sessions = getAllMovieSessionsInputPort.invoke(movieId);

        return sessions.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(sessions);
    }
}
