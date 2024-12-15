package it.bebra.cinema.database.spring.jpa.repository;

import it.bebra.cinema.database.spring.jpa.entity.JpaAuthority;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaAuthorityRepository extends JpaRepository<JpaAuthority, Integer> {
    Optional<JpaAuthority> findByName(String name);
}
