package it.bebra.cinema.domain;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.HashSet;
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

    @Builder.Default
    private Instant createTime = Instant.now();

    @Builder.Default
    private Instant updateTime = Instant.now();

    @Builder.Default
    private Set<Authority> authorities = new HashSet<>();

    public void addAuthority(final Authority authority) {
        authorities.add(authority);
    }
}
