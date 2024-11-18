package it.bebra.database.repository;

import it.bebra.database.entity.JpaTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaTicketRepository extends JpaRepository<JpaTicket, Integer> {
}