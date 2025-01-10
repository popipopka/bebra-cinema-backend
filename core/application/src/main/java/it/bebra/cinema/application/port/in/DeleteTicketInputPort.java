package it.bebra.cinema.application.port.in;

public interface DeleteTicketInputPort {
    void invoke(String username, int id);
}
