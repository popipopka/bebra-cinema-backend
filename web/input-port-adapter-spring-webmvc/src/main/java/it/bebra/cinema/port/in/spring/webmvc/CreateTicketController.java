package it.bebra.cinema.port.in.spring.webmvc;

import it.bebra.cinema.application.dto.request.TicketCreateRequestDto;
import it.bebra.cinema.application.port.in.CreateTicketInputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class CreateTicketController {
    private final CreateTicketInputPort createTicketInputPort;

    @PostMapping("/api/v1/tickets")
    public ResponseEntity<Void> createTicket(
            @AuthenticationPrincipal UserDetails userDetails,
            @RequestBody TicketCreateRequestDto body,
            UriComponentsBuilder uriBuilder
    ) {
        int ticketId = createTicketInputPort.invoke(userDetails.getUsername(), body);

        return ResponseEntity
                .created(uriBuilder
                        .pathSegment("api/v1/tickets", "{ticketId}")
                        .buildAndExpand(Map.of("ticketId", ticketId))
                        .toUri())
                .build();
    }
}
