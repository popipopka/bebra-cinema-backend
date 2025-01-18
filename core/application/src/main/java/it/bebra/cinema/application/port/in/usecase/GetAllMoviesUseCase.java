package it.bebra.cinema.application.port.in.usecase;

import it.bebra.cinema.application.dto.data.MovieData;
import it.bebra.cinema.application.dto.page.KeysetPage;
import it.bebra.cinema.application.mapper.DomainMovieMapper;
import it.bebra.cinema.application.port.in.GetAllMoviesInputPort;
import it.bebra.cinema.application.port.out.MovieOutputPort;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static it.bebra.cinema.application.dto.page.MovieKeysetCursors.*;

@RequiredArgsConstructor
public class GetAllMoviesUseCase implements GetAllMoviesInputPort {
    private final MovieOutputPort movieOutputPort;

    private final DomainMovieMapper domainMovieMapper;

    @Override
    public KeysetPage<MovieData> invoke(Optional<Integer> lastId, int limit, String query) {
        var movies = getListWithMovieData(lastId.orElse(Integer.MAX_VALUE), limit, query);

        if (movies.isEmpty()) {
            return new KeysetPage<>(movies, null, false);
        }

        int newLastId = movies.get(movies.size() - 1).getId();
        boolean hasNextPage = movieOutputPort.existsForKeysetPagination(newLastId);

        return new KeysetPage<>(movies, Map.of(LAST_ID.getValue(), newLastId), hasNextPage);
    }

    private List<MovieData> getListWithMovieData(int lastId, int limit, String query) {
        return movieOutputPort.findAllForKeysetPagination(lastId, limit, query)
                .stream()
                .map(domainMovieMapper::toData)
                .toList();
    }
}
