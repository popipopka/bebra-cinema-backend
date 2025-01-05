package it.bebra.cinema.persistence.database.spring.jpa.repository;

import it.bebra.cinema.persistence.database.spring.jpa.entity.JpaSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JpaSessionRepository extends JpaRepository<JpaSession, Integer> {

    @Query("""
            select s
            from JpaSession s
            where s.movie.id = :movieId
                and s.startTime > current_timestamp
                and 0 < (select h_n.capacity - count(t_n.id)
                        from JpaTicket t_n
                            right join JpaSession s_n on t_n.session.id = s_n.id
                            join JpaHall h_n on s_n.hall.id = h_n.id
                        where s_n.id = s.id
                        group by h_n.capacity, s_n.id)
            """)
    List<JpaSession> findAllUpcomingWithEmptySeatsByMovieId(@Param("movieId") int movieId);
}
