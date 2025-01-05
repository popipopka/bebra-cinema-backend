package it.bebra.cinema.application.port.in.usecase;

import it.bebra.cinema.application.dto.request.TicketCreateRequestDto;
import it.bebra.cinema.application.exception.SessionNotFoundException;
import it.bebra.cinema.application.exception.TicketCreateException;
import it.bebra.cinema.application.exception.UserNotFoundException;
import it.bebra.cinema.application.port.in.CreateTicketInputPort;
import it.bebra.cinema.application.port.out.SessionOutputPort;
import it.bebra.cinema.application.port.out.TicketOutputPort;
import it.bebra.cinema.application.port.out.UserOutputPort;
import it.bebra.cinema.domain.Session;
import it.bebra.cinema.domain.Ticket;
import it.bebra.cinema.domain.User;
import lombok.RequiredArgsConstructor;

import java.time.Instant;

@RequiredArgsConstructor
public class CreateTicketUseCase implements CreateTicketInputPort {
    private final TicketOutputPort ticketOutputPort;
    private final UserOutputPort userOutputPort;
    private final SessionOutputPort sessionOutputPort;

    @Override
    public int invoke(String username, TicketCreateRequestDto request) {
        int sessionId = request.getSessionId();
        Session session = sessionOutputPort.findById(sessionId)
                .orElseThrow(() -> new SessionNotFoundException(sessionId));

        validateSession(session);

        User user = userOutputPort.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException(username));

        Ticket newTicket = Ticket.builder()
                .session(session)
                .user(user)
                .row(request.getRow())
                .place(request.getPlace())
                .totalPrice(session.getPrice())
                .build();

        return ticketOutputPort.create(newTicket);
    }

    private void validateSession(Session session) {
        int sessionId = session.getId();

        if (Instant.now().isAfter(session.getStartTime())) {
            throw TicketCreateException.sessionAlreadyStarted(sessionId);
        }

        if (!hasEmptySeatsForSession(session)) {
            throw TicketCreateException.noEmptySeatsForSession(sessionId);
        }
    }

    private boolean hasEmptySeatsForSession(Session session) {
        int occupiedSeats = ticketOutputPort.countBySessionId(session.getId());
        int hallCapacity = session.getHall().getCapacity();

        return occupiedSeats < hallCapacity;
    }
}
