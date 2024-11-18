package it.bebra.cinema.repository;

import it.bebra.cinema.entity.JpaSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaSessionRepository extends JpaRepository<JpaSession, Integer> {
}