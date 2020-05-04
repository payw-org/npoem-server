package org.payw.npoem.domain.entry;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Poem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    todo : release comment when user and dictionary entity implemented
//    @ManyToOne
//    @JoinColumn(name = "user_id", nullable = false, updatable = false)
//    private User user;

    @ManyToOne
    @JoinColumn(name = "word_id", nullable = false, updatable = false)
    private Word word;

    @Column(length = 500, nullable = false)
    private String content;

    @Column(nullable = false)
    private Double timeSpent;

    @Builder
    public Poem(String content, Double timeSpent, Word word) {
        this.content = content;
        this.timeSpent = timeSpent;
        this.word = word;
    }
}
