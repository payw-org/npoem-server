package org.payw.npoem.domain.entry;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class TodayWord {
    // todo : add created using Jpa Auditing

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String text;

    public TodayWord(String text) {
        this.text = text;
    }
}
