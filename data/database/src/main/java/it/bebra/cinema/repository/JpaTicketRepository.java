package it.bebra.cinema.repository;

import it.bebra.cinema.entity.JpaTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaTicketRepository extends JpaRepository<JpaTicket, Integer> {
}