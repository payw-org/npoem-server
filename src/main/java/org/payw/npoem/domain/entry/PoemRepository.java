package org.payw.npoem.domain.entry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PoemRepository extends JpaRepository<Poem, Long> {
    Optional<Poem> findByUser_idAndCreatedBetween(@Param("user_id") Long user_id, LocalDateTime start, LocalDateTime end);
}
