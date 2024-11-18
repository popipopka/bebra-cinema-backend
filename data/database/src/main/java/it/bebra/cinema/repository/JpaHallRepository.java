package it.bebra.cinema.repository;

import it.bebra.cinema.entity.JpaHall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaHallRepository extends JpaRepository<JpaHall, Integer> {

}