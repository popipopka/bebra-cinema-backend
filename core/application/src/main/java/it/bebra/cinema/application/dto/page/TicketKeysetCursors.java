package it.bebra.cinema.application.dto.page;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TicketKeysetCursors {
    LAST_ID("lastId");

    private final String value;
}

