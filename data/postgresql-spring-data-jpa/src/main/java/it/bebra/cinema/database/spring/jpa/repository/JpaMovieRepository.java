package it.bebra.cinema.database.spring.jpa.repository;

import it.bebra.cinema.database.spring.jpa.entity.JpaMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaMovieRepository extends JpaRepository<JpaMovie, Integer> {
    Optional<JpaMovie> findById(int id);
}