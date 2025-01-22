package it.bebra.cinema.port.in.spring.webmvc.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import it.bebra.cinema.application.port.in.GetUserInputPort;
import it.bebra.cinema.port.in.spring.webmvc.dto.UserDetailResponseDto;
import it.bebra.cinema.port.in.spring.webmvc.mapper.UserDataMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Пользователи", description = "Управление пользователями")
@RestController
@RequiredArgsConstructor
public class GetCurrentUserController {
    private final GetUserInputPort getUserInputPort;
    private final UserDataMapper userDataMapper;

    @Operation(
            summary = "Получить данные авторизированного пользователя",
            description = "Получение данных текущего авторизированного пользователя",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Данные пользователя",
                            content = @Content(
                                    schema = @Schema(implementation = UserDetailResponseDto.class),
                                    mediaType = "application/json"
                            )
                    ),
                    @ApiResponse(
                            responseCode = "401",
                            description = "Пользователь не авторизирован",
                            content = @Content
                    )
            },
            security = @SecurityRequirement(name = "JWT")
    )
    @GetMapping(value = "api/v1/users/me", produces = "application/json")
    public ResponseEntity<UserDetailResponseDto> getCurrentUser(@AuthenticationPrincipal UserDetails userDetails) {
        var user = userDataMapper.toDetailDto(
                getUserInputPort.invoke(userDetails.getUsername())
        );

        return ResponseEntity.ok(user);
    }
}
