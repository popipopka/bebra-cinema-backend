package it.bebra.cinema.application.dto.page;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MovieKeysetCursors {
    LAST_ID("lastId");

    private final String value;
}
