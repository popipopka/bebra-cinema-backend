package it.bebra.cinema.port.in.spring.webmvc;

import it.bebra.cinema.application.dto.page.KeysetPageDto;
import it.bebra.cinema.application.dto.response.MovieListResponseDto;
import it.bebra.cinema.application.port.in.GetAllMoviesInputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class GetAllMoviesController {
    private final GetAllMoviesInputPort getAllMoviesInputPort;

    @GetMapping("/api/v1/movies")
    public ResponseEntity<KeysetPageDto<MovieListResponseDto>> getAllMovies(
            @RequestParam(required = false) Optional<Integer> lastId,
            @RequestParam(required = false, defaultValue = "20") int limit,
            @RequestParam(required = false, defaultValue = "") String query
    ) {
        var movies = getAllMoviesInputPort.invoke(lastId, limit, query);

        return movies.getItems().isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(movies);
    }
}
