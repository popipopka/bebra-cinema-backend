package it.bebra.cinema.database.repository;

import it.bebra.cinema.database.entity.JpaTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaTicketRepository extends JpaRepository<JpaTicket, Integer> {

    List<JpaTicket> findAllByUserUsername(String username);
}