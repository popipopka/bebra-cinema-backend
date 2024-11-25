package it.bebra.domain.model;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.Set;

@Data
@Builder
public final class User {
    private Integer id;

    private String firstName;

    private String lastName;

    private String email;

    private String username;

    private String password;

    private Instant createTime;

    private Instant updateTime;

    private Set<Authority> authorities;
}
