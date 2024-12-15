package it.bebra.cinema.database.spring.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "\"user\"")
public final class JpaUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(nullable = false, length = 64)
    private String firstName;

    @Column(nullable = false, length = 64)
    private String lastName;

    @Column(nullable = false, unique = true, length = 64)
    private String email;

    @Column(nullable = false, unique = true, length = 32)
    private String username;

    @Column(name = "password_hash", columnDefinition = "TEXT", nullable = false, unique = true)
    private String password;

    @Column(nullable = false)
    private Instant createdTime;

    @Column(nullable = false)
    private Instant updatedTime;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_authority",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id"))
    private Set<JpaAuthority> authorities = new HashSet<>();
}
