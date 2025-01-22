package it.bebra.cinema.port.in.spring.webmvc.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import it.bebra.cinema.port.in.spring.webmvc.dto.LoginResponseDto;
import it.bebra.cinema.port.in.spring.webmvc.mapper.JwtTokensMapper;
import it.bebra.cinema.security.jwt.dto.LoginRequestDto;
import it.bebra.cinema.security.jwt.port.in.LoginInputPort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Аутентификация", description = "Управление аутентификацией")
@RestController
@RequiredArgsConstructor
public class LoginController {
    private final LoginInputPort loginInputPort;
    private final JwtTokensMapper jwtTokensMapper;

    @Operation(
            summary = "Войти в систему",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Access Token"
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Пользователь не найден",
                            content = @Content
                    ),
                    @ApiResponse(
                            responseCode = "401",
                            description = "Неверный пароль",
                            content = @Content
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Ошибка при валидации тела запроса",
                            content = @Content
                    )
            },
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            schema = @Schema(implementation = LoginRequestDto.class),
                            examples = @ExampleObject(
                                    name = "Данные для входа в систему",
                                    value = """
                                            {
                                                "username": "user123",
                                                "password": "password123."
                                            }
                                            """
                            )
                    )
            )
    )
    @PostMapping(value = "api/v1/auth/login", produces = "application/json")
    public ResponseEntity<LoginResponseDto> login(@Valid @RequestBody LoginRequestDto body) {
        var tokensData = loginInputPort.invoke(body);

        return ResponseEntity.ok(
                jwtTokensMapper.toDto(tokensData)
        );
    }
}
