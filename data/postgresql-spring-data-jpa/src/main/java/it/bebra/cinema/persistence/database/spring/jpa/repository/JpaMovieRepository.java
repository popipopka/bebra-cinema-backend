package it.bebra.cinema.persistence.database.spring.jpa.repository;

import it.bebra.cinema.persistence.database.spring.jpa.entity.JpaMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaMovieRepository extends JpaRepository<JpaMovie, Integer> {
    Optional<JpaMovie> findById(int id);
}