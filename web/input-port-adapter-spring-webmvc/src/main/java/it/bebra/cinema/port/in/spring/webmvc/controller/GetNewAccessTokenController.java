package it.bebra.cinema.port.in.spring.webmvc.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import it.bebra.cinema.port.in.spring.webmvc.dto.AccessTokenDto;
import it.bebra.cinema.port.in.spring.webmvc.dto.RefreshTokenDto;
import it.bebra.cinema.security.jwt.port.in.GetNewAccessTokenInputPort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Аутентификация", description = "Управление аутентификацией")
@RestController
@RequiredArgsConstructor
public class GetNewAccessTokenController {
    private final GetNewAccessTokenInputPort getNewAccessTokenInputPort;

    @Operation(
            summary = "Получить новый Access Token",
            description = "Получение нового Access Token'а",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Access Token"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Неверный Refresh Token",
                            content = @Content
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Ошибка при валидации тела запроса",
                            content = @Content
                    )
            }
    )
    @PostMapping(value = "api/v1/auth/token", produces = "application/json")
    public ResponseEntity<AccessTokenDto> getNewAccessToken(@Valid @RequestBody RefreshTokenDto refreshToken) {
        var accessToken = getNewAccessTokenInputPort.invoke(refreshToken.getRefreshToken());

        return ResponseEntity.ok(AccessTokenDto.of(accessToken));
    }
}
