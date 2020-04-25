package org.payw.npoem.domain.entry;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PoemRepository extends JpaRepository<Poem, Long> {
}
