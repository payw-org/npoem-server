package org.payw.npoem.domain.entry;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.payw.npoem.domain.entry.Poem;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class WordDictionary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String word;

    @OneToMany(mappedBy = "word")
    private List<Poem> poems;

    @Builder
    public WordDictionary(String word) {
        this.word = word;
    }
}
