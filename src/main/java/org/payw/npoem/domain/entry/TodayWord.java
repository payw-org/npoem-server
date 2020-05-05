package org.payw.npoem.domain.entry;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class TodayWord {
    // todo : add created using Jpa Auditing

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "word_id", nullable = false, updatable = false)
    private Word word;

    public TodayWord(Word word) {
        this.word = word;
    }
}
