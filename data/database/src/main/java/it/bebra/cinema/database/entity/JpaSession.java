package it.bebra.cinema.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "session")
public final class JpaSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "movie_id", nullable = false)
    private JpaMovie movie;

    @ManyToOne(optional = false)
    @JoinColumn(name = "hall_id", nullable = false)
    private JpaHall hall;

    @Column(nullable = false)
    private Instant startTime;

    @Column(nullable = false)
    private Float price;
}
