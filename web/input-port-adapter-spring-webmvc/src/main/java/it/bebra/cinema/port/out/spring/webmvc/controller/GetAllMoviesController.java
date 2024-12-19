package it.bebra.cinema.port.out.spring.webmvc.controller;

import it.bebra.cinema.application.dto.MovieListResponseDto;
import it.bebra.cinema.application.port.in.GetAllMoviesInputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GetAllMoviesController {
    private final GetAllMoviesInputPort getAllMoviesInputPort;

    @GetMapping("/api/v1/movies")
    public ResponseEntity<List<MovieListResponseDto>> getAllMovies() {
        List<MovieListResponseDto> movies = getAllMoviesInputPort.invoke();

        return movies.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(movies);
    }
}
