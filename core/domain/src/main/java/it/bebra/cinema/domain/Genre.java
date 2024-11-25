package it.bebra.cinema.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public final class Genre {
    private Integer id;

    private String name;
}
