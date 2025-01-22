package it.bebra.cinema.port.in.spring.webmvc.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Schema(description = "JWT Refresh Token")
@Data
public class RefreshTokenDto {
    @Schema(description = "Refresh Token")
    @NotBlank
    private String refreshToken;
}
