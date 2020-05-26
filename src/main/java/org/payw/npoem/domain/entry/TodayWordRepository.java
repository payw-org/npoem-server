package org.payw.npoem.domain.entry;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodayWordRepository extends JpaRepository<TodayWord, Long> {
    TodayWord findFirstByOrderByIdDesc();
}
