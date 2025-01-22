package it.bebra.cinema.port.in.spring.webmvc.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import it.bebra.cinema.application.port.in.SoftDeleteUserInputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Пользователи", description = "Управление пользователями")
@RestController
@RequiredArgsConstructor
public class SoftDeleteCurrentUserController {
    private final SoftDeleteUserInputPort softDeleteUserInputPort;

    @Operation(
            summary = "Мягко удалить авторизированного пользователя",
            description = "Мягкое удаление текущего авторизированного пользователя",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Пользователь мягко удален"
                    ),
                    @ApiResponse(
                            responseCode = "401",
                            description = "Пользователь не авторизован"
                    ),
                    @ApiResponse(
                            responseCode = "401",
                            description = "Пользователь не авторизирован"
                    )
            },
            security = @SecurityRequirement(name = "JWT")
    )
    @DeleteMapping(value = "api/v1/users/me")
    public ResponseEntity<Void> softDeleteUser(@AuthenticationPrincipal UserDetails userDetails) {
        softDeleteUserInputPort.invoke(userDetails.getUsername());

        return ResponseEntity.ok().build();
    }
}
