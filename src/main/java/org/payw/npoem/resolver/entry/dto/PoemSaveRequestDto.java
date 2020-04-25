package org.payw.npoem.resolver.entry.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PoemSaveRequestDto {
    private String content;
    private Integer spentTime;
    private Long word_id;

    @Builder
    public PoemSaveRequestDto(String content, Integer spentTime, Long word_id) {
        this.content = content;
        this.spentTime = spentTime;
        this.word_id = word_id;
    }
}
