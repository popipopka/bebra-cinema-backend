package it.bebra.cinema.database.repository;

import it.bebra.cinema.database.entity.JpaUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaUserRepository extends JpaRepository<JpaUser, Integer> {

    Optional<JpaUser> findByUsername(String username);
}