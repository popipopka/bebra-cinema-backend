package it.bebra.cinema.port.in.spring.webmvc.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import it.bebra.cinema.application.port.in.DeleteTicketInputPort;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Билеты", description = "Управление билетами")
@RestController
@RequiredArgsConstructor
public class DeleteTicketController {
    private final DeleteTicketInputPort deleteTicketInputPort;

    @Operation(
            summary = "Удалить билет по ID",
            description = "Удаление билета у текущего авторизированного пользователя по идентификатору ID",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Билет удален"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "До начала сессии осталось меньше 1 часа"
                    ),
                    @ApiResponse(
                            responseCode = "403",
                            description = "Билет не принадлежит текущему пользователю"
                    ),
                    @ApiResponse(
                            responseCode = "401",
                            description = "Пользователь не авторизирован"
                    )
            },
            parameters = {
                    @Parameter(
                            name = "id",
                            description = "Идентификатор билета",
                            example = "1"
                    )
            },
            security = @SecurityRequirement(name = "JWT")
    )
    @DeleteMapping("api/v1/tickets/{id:^\\d*$}")
    public ResponseEntity<Void> deleteTicket(
            @PathVariable @Min(1) int id,
            @AuthenticationPrincipal UserDetails userDetails
    ) {
        deleteTicketInputPort.invoke(userDetails.getUsername(), id);

        return ResponseEntity.ok().build();
    }
}
