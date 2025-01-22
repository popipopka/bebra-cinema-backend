package it.bebra.cinema.port.in.spring.webmvc.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Schema(description = "Детальная информация о пользователе")
@Data
@Builder
public class UserDetailResponseDto {

    @Schema(description = "Идентификатор пользователя", example = "1")
    private int id;

    @Schema(description = "Имя пользователя", example = "Иван")
    private String firstName;

    @Schema(description = "Фамилия пользователя", example = "Иванов")
    private String lastName;

    @Schema(description = "Электронная почта пользователя", example = "ivan@example.com")
    private String email;

    @Schema(description = "Время создания учетной записи", example = "2023-10-15T18:00:00Z")
    private Instant createdTime;

    @Schema(description = "Время последнего обновления учетной записи", example = "2023-10-15T18:00:00Z")
    private Instant updatedTime;
}
