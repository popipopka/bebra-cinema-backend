package it.bebra.database.repository;

import it.bebra.database.entity.JpaHall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaHallRepository extends JpaRepository<JpaHall, Integer> {

}