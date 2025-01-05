package it.bebra.cinema.application.port.in.usecase;

import it.bebra.cinema.application.dto.page.KeysetPageDto;
import it.bebra.cinema.application.dto.response.MovieListResponseDto;
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
    public KeysetPageDto<MovieListResponseDto> invoke(Optional<Integer> lastId, int limit) {
        var movies = getListWithMovieListResponseDto(lastId.orElse(Integer.MAX_VALUE), limit);

        if (movies.isEmpty()) {
            return new KeysetPageDto<>(movies, null, false);
        }

        int newLastId = movies.get(movies.size() - 1).getId();
        boolean hasNextPage = movieOutputPort.existsByIdLessThan(newLastId);

        return new KeysetPageDto<>(movies, Map.of(LAST_ID.getValue(), newLastId), hasNextPage);
    }

    private List<MovieListResponseDto> getListWithMovieListResponseDto(int lastId, int limit) {
        return movieOutputPort.findAllWithLimitByIdLessThan(lastId, limit)
                .stream()
                .map(domainMovieMapper::toListDto)
                .toList();
    }
}
