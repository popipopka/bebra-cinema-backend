package it.bebra.cinema.database.repository;

import it.bebra.cinema.database.entity.JpaMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaMovieRepository extends JpaRepository<JpaMovie, Integer> {
}