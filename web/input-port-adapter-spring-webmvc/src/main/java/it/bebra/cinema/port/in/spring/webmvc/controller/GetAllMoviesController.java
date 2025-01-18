package it.bebra.cinema.port.in.spring.webmvc.controller;

import it.bebra.cinema.application.dto.page.KeysetPage;
import it.bebra.cinema.port.in.spring.webmvc.dto.MovieListResponseDto;
import it.bebra.cinema.application.port.in.GetAllMoviesInputPort;
import it.bebra.cinema.port.in.spring.webmvc.mapper.KeysetPageMapper;
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
    private final KeysetPageMapper keysetPageMapper;

    @GetMapping("/api/v1/movies")
    public ResponseEntity<KeysetPage<MovieListResponseDto>> getAllMovies(
            @RequestParam(required = false) Optional<Integer> lastId,
            @RequestParam(required = false, defaultValue = "20") int limit,
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
