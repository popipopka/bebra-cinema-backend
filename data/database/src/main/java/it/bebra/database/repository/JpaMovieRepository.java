package it.bebra.database.repository;

import it.bebra.database.entity.JpaMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaMovieRepository extends JpaRepository<JpaMovie, Integer> {
}