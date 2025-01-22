package it.bebra.cinema.port.in.spring.webmvc.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import it.bebra.cinema.application.dto.page.KeysetPage;
import it.bebra.cinema.application.port.in.GetAllTicketsInputPort;
import it.bebra.cinema.port.in.spring.webmvc.dto.TicketListResponseDto;
import it.bebra.cinema.port.in.spring.webmvc.mapper.KeysetPageMapper;
import it.bebra.cinema.port.in.spring.webmvc.openapi.schema.KeysetPageTicketListResponseDtoSchema;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Билеты", description = "Управление билетами")
@RestController
@RequiredArgsConstructor
@Validated
public class GetAllTicketsController {
    private final GetAllTicketsInputPort getAllTicketsUseCase;
    private final KeysetPageMapper keysetPageMapper;

    @Operation(
            summary = "Постранично получить билеты",
            description = "Постраничное получение билетов текущего авторизированного пользователя",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Список билетов",
                            content = @Content(
                                    schema = @Schema(
                                            implementation = KeysetPageTicketListResponseDtoSchema.class
                                    )
                            )

                    ),
                    @ApiResponse(
                            responseCode = "204",
                            description = "Билетов нет",
                            content = @Content
                    ),
                    @ApiResponse(
                            responseCode = "401",
                            description = "Пользователь не авторизирован",
                            content = @Content
                    )
            },
            parameters = {
                    @Parameter(
                            name = "lastId",
                            description = "Идентификатор последнего билета в странице",
                            example = "1"
                    ),
                    @Parameter(
                            name = "limit",
                            description = "Кол-во билетов на странице",
                            example = "20"
                    )
            },
            security = @SecurityRequirement(name = "JWT")
    )
    @GetMapping(value = "api/v1/tickets", produces = "application/json")
    public ResponseEntity<KeysetPage<TicketListResponseDto>> getAllTickets(
            @AuthenticationPrincipal UserDetails user,
            @RequestParam(required = false) @Min(1) Integer lastId,
            @RequestParam(required = false, defaultValue = "10") @Min(1) int limit
    ) {
        var ticketPage = keysetPageMapper.toTicketPage(
                getAllTicketsUseCase.invoke(user.getUsername(), lastId, limit)
        );

        return ticketPage.getItems().isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(ticketPage);
    }
}
