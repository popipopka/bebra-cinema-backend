package it.bebra.cinema.controller;

import it.bebra.cinema.usecase.dto.TicketListResponseDto;
import it.bebra.cinema.usecase.port.in.GetAllTicketsUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/tickets")
@RequiredArgsConstructor
public class TicketController {
    private final GetAllTicketsUseCase getAllTicketsUseCase;

    @GetMapping
    public ResponseEntity<List<TicketListResponseDto>> getAllTickets(@RequestParam String username) {
        List<TicketListResponseDto> result = getAllTicketsUseCase.invoke(username);

        return result.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(result);
    }
}
