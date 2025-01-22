package it.bebra.cinema.application.port.in.usecase;

import it.bebra.cinema.application.exception.TicketDeleteException;
import it.bebra.cinema.application.exception.TicketNotFoundException;
import it.bebra.cinema.application.exception.TooCloseToSessionException;
import it.bebra.cinema.application.port.in.DeleteTicketInputPort;
import it.bebra.cinema.application.port.out.TicketOutputPort;
import it.bebra.cinema.domain.Session;
import it.bebra.cinema.domain.Ticket;
import lombok.RequiredArgsConstructor;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@RequiredArgsConstructor
public class DeleteTicketUseCase implements DeleteTicketInputPort {
    private static final int SESSION_START_TIME_LIMIT = 1;
    private static final ChronoUnit UNIT_OF_SESSION_START_TIME_LIMIT = ChronoUnit.HOURS;

    private final TicketOutputPort ticketOutputPort;

    @Override
    public void invoke(String username, int id) {
        Ticket ticket = ticketOutputPort.findById(id)
                .orElseThrow(() -> new TicketNotFoundException(id));

        String ownerUsername = ticket.getUser().getUsername();
        if (!ownerUsername.equals(username)) {
            throw new TicketDeleteException(username, id);
        }

        Session session = ticket.getSession();
        if (!validateSessionStartTime(session)) {
            throw new TooCloseToSessionException(SESSION_START_TIME_LIMIT, UNIT_OF_SESSION_START_TIME_LIMIT, session.getId());
        }

        ticketOutputPort.delete(id);
    }

    private boolean validateSessionStartTime(Session session) {
        return Instant.now()
                .plus(SESSION_START_TIME_LIMIT, UNIT_OF_SESSION_START_TIME_LIMIT)
                .isBefore(session.getStartTime());
    }
}
