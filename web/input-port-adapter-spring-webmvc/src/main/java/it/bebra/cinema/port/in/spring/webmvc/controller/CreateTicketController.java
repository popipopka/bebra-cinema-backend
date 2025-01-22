package it.bebra.cinema.port.in.spring.webmvc.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import it.bebra.cinema.application.dto.request.TicketCreateRequest;
import it.bebra.cinema.application.port.in.CreateTicketInputPort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@Tag(name = "Билеты", description = "Управление билетами")
@RestController
@RequiredArgsConstructor
public class CreateTicketController {
    private final CreateTicketInputPort createTicketInputPort;

    @Operation(
            summary = "Создать билет",
            description = "Создание билета у текущего авторизированного пользователя",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Билет создан",
                            headers = @Header(
                                    name = "Location",
                                    description = "Расположение созданного билета"
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = """
                                    На сеанс нет свободных мест\n
                                    Сеанс уже начался\n
                                    Ошибка при валидации тела запроса
                                    """
                    ),
                    @ApiResponse(
                            responseCode = "401",
                            description = "Пользователь не авторизирован"
                    )
            },
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            schema = @Schema(implementation = TicketCreateRequest.class),
                            examples = @ExampleObject(
                                    name = "Данные для создания билета",
                                    value = """
                                            {
                                                "sessionId": "1",
                                                "row": "5",
                                                "place": "12"
                                            }
                                            """
                            )
                    )
            ),
            security = @SecurityRequirement(name = "JWT")
    )
    @PostMapping("/api/v1/tickets")
    public ResponseEntity<Void> createTicket(
            @AuthenticationPrincipal UserDetails userDetails,
            @Valid @RequestBody TicketCreateRequest body,
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
