package it.bebra.cinema.port.in.spring.webmvc;

import it.bebra.cinema.application.dto.response.MovieDetailResponseDto;
import it.bebra.cinema.application.port.in.GetMovieInputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GetMovieController {
    private final GetMovieInputPort getMovieInputPort;

    @GetMapping("/api/v1/movies/{id:^\\d+$}")
    public ResponseEntity<MovieDetailResponseDto> getMovie(@PathVariable int id) {
        var movie = getMovieInputPort.invoke(id);

        return ResponseEntity.ok(movie);
    }
}
