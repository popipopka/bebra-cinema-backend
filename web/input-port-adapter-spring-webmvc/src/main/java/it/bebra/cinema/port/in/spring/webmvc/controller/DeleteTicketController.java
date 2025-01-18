package it.bebra.cinema.port.in.spring.webmvc.controller;

import it.bebra.cinema.application.port.in.DeleteTicketInputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DeleteTicketController {
    private final DeleteTicketInputPort deleteTicketInputPort;

    @DeleteMapping("api/v1/tickets/{id:^\\d*$}")
    public ResponseEntity<Void> deleteTicket(@PathVariable int id,
                                             @AuthenticationPrincipal UserDetails userDetails) {
        deleteTicketInputPort.invoke(userDetails.getUsername(), id);

        return ResponseEntity.ok().build();
    }
}
