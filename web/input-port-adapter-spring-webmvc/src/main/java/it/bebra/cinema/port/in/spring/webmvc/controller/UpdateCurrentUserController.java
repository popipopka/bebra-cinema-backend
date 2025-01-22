package it.bebra.cinema.port.in.spring.webmvc.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import it.bebra.cinema.application.dto.request.UserUpdateRequest;
import it.bebra.cinema.application.port.in.UpdateUserInputPort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Пользователи", description = "Управление пользователями")
@RestController
@RequiredArgsConstructor
public class UpdateCurrentUserController {
    private final UpdateUserInputPort updateUserInputPort;

    @Operation(
            summary = "Обновить авторизированного пользователя",
            description = "Обновление текущего авторизированного пользователя",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Пользователь обновлен"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Ошибка при валидации тела запроса"
                    ),
                    @ApiResponse(
                            responseCode = "401",
                            description = "Пользователь не авторизирован"
                    )
            },
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            schema = @Schema(implementation = UserUpdateRequest.class),
                            examples = @ExampleObject(
                                    name = "Данные для обновления пользователя",
                                    value = """
                                            {
                                                "firstName": "Иван",
                                                "lastName": "Иванов",
                                                "email": "ivan@example.com"
                                            }
                                            """
                            )
                    )
            ),
            security = @SecurityRequirement(name = "JWT")
    )
    @PatchMapping("api/v1/users/me")
    public ResponseEntity<Void> updateUser(
            @AuthenticationPrincipal UserDetails userDetails,
            @Valid @RequestBody UserUpdateRequest body
    ) {
        updateUserInputPort.invoke(userDetails.getUsername(), body);

        return ResponseEntity.ok().build();
    }
}
