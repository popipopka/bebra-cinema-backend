package it.bebra.cinema.port.in.spring.webmvc.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import it.bebra.cinema.application.dto.request.UserCreateRequest;
import it.bebra.cinema.application.port.in.CreateUserInputPort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@Tag(name = "Пользователи", description = "Управление пользователями")
@RestController
@RequiredArgsConstructor
public class CreateUserController {
    private final CreateUserInputPort createUserInputPort;

    @Operation(
            summary = "Создать нового пользователя",
            description = "Создание нового пользователя",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Пользователя создан",
                            headers = @Header(
                                    name = "Location",
                                    description = "Расположение созданного пользователя"
                            )
                    ),
                    @ApiResponse(
                            responseCode = "409",
                            description = "Пользователь уже существует"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Ошибка при валидации тела запроса"
                    )
            },
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            schema = @Schema(implementation = UserCreateRequest.class),
                            examples = @ExampleObject(
                                    name = "Данные для создания пользователя",
                                    value = """
                                            {
                                                "firstName": "Иван",
                                                "lastName": "Иванов",
                                                "email": "ivan@example.com",
                                                "username": "ivanov",
                                                "password": "Password123"
                                            }
                                            """
                            )
                    )
            )
    )
    @PostMapping("api/v1/users")
    public ResponseEntity<Void> createUser(
            @Valid @RequestBody UserCreateRequest body,
            UriComponentsBuilder uriBuilder
    ) {
        int userId = createUserInputPort.invoke(body);

        return ResponseEntity
                .created(uriBuilder
                        .pathSegment("api/v1/users", "{userId}")
                        .buildAndExpand(Map.of("userId", userId))
                        .toUri())
                .build();
    }
}
