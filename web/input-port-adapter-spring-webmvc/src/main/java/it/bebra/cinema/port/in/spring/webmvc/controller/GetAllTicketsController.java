package it.bebra.cinema.port.in.spring.webmvc.controller;

import it.bebra.cinema.application.dto.page.KeysetPage;
import it.bebra.cinema.application.port.in.GetAllTicketsInputPort;
import it.bebra.cinema.port.in.spring.webmvc.dto.TicketListResponseDto;
import it.bebra.cinema.port.in.spring.webmvc.mapper.KeysetPageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GetAllTicketsController {
    private final GetAllTicketsInputPort getAllTicketsUseCase;
    private final KeysetPageMapper keysetPageMapper;

    @GetMapping("api/v1/tickets")
    public ResponseEntity<KeysetPage<TicketListResponseDto>> getAllTickets(
            @AuthenticationPrincipal UserDetails user,
            @RequestParam(required = false) Integer lastId,
            @RequestParam(required = false, defaultValue = "10") int limit
    ) {
        var ticketPage = keysetPageMapper.toTicketPage(
                getAllTicketsUseCase.invoke(user.getUsername(), lastId, limit)
        );

        return ticketPage.getItems().isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(ticketPage);
    }
}
