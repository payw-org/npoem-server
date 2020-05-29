package org.payw.npoem.domain.entry;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.payw.npoem.domain.BaseTimeEntity;
import org.payw.npoem.domain.user.User;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Poem extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, updatable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "word_id", nullable = false, updatable = false)
    private Word word;

    @Column(length = 500, nullable = false)
    private String content;

    @Column(nullable = false)
    private Double timeSpent;

    // todo : release comment when user and dictionary entity implemented

    @Builder
    public Poem(String content, Double timeSpent, Word word, User user) {
        this.content = content;
        this.timeSpent = timeSpent;
        this.word = word;
        this.user = user;
    }
}
