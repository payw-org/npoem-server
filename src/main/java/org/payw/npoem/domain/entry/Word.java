package org.payw.npoem.domain.entry;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.payw.npoem.domain.BaseTimeEntity;
import org.payw.npoem.domain.entry.Poem;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Word extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String text;

    @OneToMany(mappedBy = "word")
    private List<Poem> poems;

    @Builder
    public Word(String text) {
        this.text = text;
    }
}
