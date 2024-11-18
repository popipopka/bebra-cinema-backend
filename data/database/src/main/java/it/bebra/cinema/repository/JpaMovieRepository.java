package it.bebra.cinema.repository;

import it.bebra.cinema.entity.JpaMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaMovieRepository extends JpaRepository<JpaMovie, Integer> {
}