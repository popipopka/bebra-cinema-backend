package it.bebra.cinema.database.repository;

import it.bebra.cinema.database.entity.JpaHall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaHallRepository extends JpaRepository<JpaHall, Integer> {

}