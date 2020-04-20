package com.payw.npoem.domain.entry;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
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

//    @ManyToOne
//    @JoinColumn(name = "word_dictionary_id", nullable = false, updatable = false)
//    private WordDictionary wordDictionary;

    @Column(length = 500, nullable = false)
    private String content;

    @Column
    private Integer spentTime;

    @Builder
    public Poem(String content, Integer spentTime) {
        this.content = content;
        this.spentTime = spentTime;
    }
}
