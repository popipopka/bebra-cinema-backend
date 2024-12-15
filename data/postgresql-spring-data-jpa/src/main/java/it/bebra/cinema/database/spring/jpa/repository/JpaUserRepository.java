package it.bebra.cinema.database.spring.jpa.repository;

import it.bebra.cinema.database.spring.jpa.entity.JpaUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaUserRepository extends JpaRepository<JpaUser, Integer> {

    Optional<JpaUser> findByUsername(String username);
}