package it.bebra.cinema.port.in.spring.webmvc;

import it.bebra.cinema.application.dto.TicketListResponseDto;
import it.bebra.cinema.application.port.in.GetAllTicketsInputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GetAllTicketsController {
    private final GetAllTicketsInputPort getAllTicketsUseCase;

    @GetMapping("api/v1/tickets")
    public ResponseEntity<List<TicketListResponseDto>> getAllTickets(@AuthenticationPrincipal UserDetails user) {
        List<TicketListResponseDto> result = getAllTicketsUseCase.invoke(user.getUsername());

        return result.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(result);
    }
}
