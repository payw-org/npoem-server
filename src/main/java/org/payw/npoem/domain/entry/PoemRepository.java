package org.payw.npoem.domain.entry;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PoemRepository extends JpaRepository<Poem, Long> {
    Optional<Poem> findByUserIdAndCreatedBetween(Long userId, LocalDateTime start, LocalDateTime end);
}
