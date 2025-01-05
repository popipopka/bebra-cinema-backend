package it.bebra.cinema.port.in.spring.webmvc;

import it.bebra.cinema.application.dto.page.KeysetPageDto;
import it.bebra.cinema.application.dto.response.TicketListResponseDto;
import it.bebra.cinema.application.port.in.GetAllTicketsInputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class GetAllTicketsController {
    private final GetAllTicketsInputPort getAllTicketsUseCase;

    @GetMapping("api/v1/tickets")
    public ResponseEntity<KeysetPageDto<TicketListResponseDto>> getAllTickets(
            @AuthenticationPrincipal UserDetails user,
            @RequestParam(required = false) Optional<Integer> lastId,
            @RequestParam(required = false, defaultValue = "10") int limit
    ) {
        var result = getAllTicketsUseCase.invoke(user.getUsername(), lastId, limit);

        return result.getItems().isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(result);
    }
}
