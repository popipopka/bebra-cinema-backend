package it.bebra.cinema.application.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserCreateRequest {

    @NotBlank
    @Size(min = 1, max = 64)
    private String firstName;

    @NotBlank
    @Size(min = 1, max = 64)
    private String lastName;

    @NotBlank
    @Email
    @Size(min = 1, max = 64)
    private String email;

    @NotBlank
    @Size(min = 4, max = 32)
    private String username;

    @NotBlank
    @Size(min = 8, max = 32)
    private String password;
}
