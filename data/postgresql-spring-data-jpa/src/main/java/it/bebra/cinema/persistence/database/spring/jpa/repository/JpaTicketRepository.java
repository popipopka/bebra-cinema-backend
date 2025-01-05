package it.bebra.cinema.persistence.database.spring.jpa.repository;

import it.bebra.cinema.persistence.database.spring.jpa.entity.JpaTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaTicketRepository extends JpaRepository<JpaTicket, Integer> {

    @Query("""
            select t
            from JpaTicket t
            where t.id < :id
                and t.user.username = :username
            order by t.id desc
            fetch next :limit rows only
            """)
    List<JpaTicket> findAllWithLimitByUserUsernameAndIdLessThan(@Param("username") String username,
                                                                @Param("id") int id,
                                                                @Param("limit") int limit);
    @Query("""
            select exists
            (select 1
                from JpaTicket t
                where t.user.username = :username
                    and t.id < :id)
            """)
    boolean existsByUserUsernameAndIdLessThan(@Param("username") String username, @Param("id") int id);

    int countBySessionId(Integer sessionId);
}