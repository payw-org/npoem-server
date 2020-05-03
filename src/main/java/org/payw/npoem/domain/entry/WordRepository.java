package org.payw.npoem.domain.entry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface WordRepository extends JpaRepository<Word, Long> {

    @Query(nativeQuery=true, value="SELECT *  FROM word ORDER BY rand() LIMIT 1")
    Word findRandomWord();
}
