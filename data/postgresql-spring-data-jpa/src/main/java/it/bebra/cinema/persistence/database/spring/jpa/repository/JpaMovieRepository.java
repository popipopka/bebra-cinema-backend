package it.bebra.cinema.persistence.database.spring.jpa.repository;

import it.bebra.cinema.persistence.database.spring.jpa.entity.JpaMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JpaMovieRepository extends JpaRepository<JpaMovie, Integer> {
    Optional<JpaMovie> findById(int id);

    @Query("""
            select m 
            from JpaMovie m
            where m.id < :id
            order by m.id desc
            fetch next :limit rows only
            """)
    List<JpaMovie> findAllWithLimitByIdLessThan(@Param("id") int id, @Param("limit") int limit);

    @Query("""
            select exists 
            (select 1 
                from JpaMovie 
                where id < :id)
            """)
    boolean existsByIdLessThan(@Param("id") int id);
}