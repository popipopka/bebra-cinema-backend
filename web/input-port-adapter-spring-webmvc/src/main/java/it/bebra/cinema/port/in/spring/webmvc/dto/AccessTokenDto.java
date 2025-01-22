package it.bebra.cinema.port.in.spring.webmvc.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Schema(description = "JWT Access Token")
@Data
@AllArgsConstructor(staticName = "of")
public class AccessTokenDto {
    @Schema(description = "Access Token")
    private String accessToken;
}
