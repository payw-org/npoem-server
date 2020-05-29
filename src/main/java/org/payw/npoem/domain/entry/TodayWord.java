package org.payw.npoem.domain.entry;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import org.payw.npoem.domain.BaseTimeEntity;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class TodayWord  extends BaseTimeEntity {
    // todo : add created using Jpa Auditing

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "word_id", nullable = false, updatable = false)
    private Word word;

    @Builder
    public TodayWord(Word word) {
        this.word = word;
    }
}
