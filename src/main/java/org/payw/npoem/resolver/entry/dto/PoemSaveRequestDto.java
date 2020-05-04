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
    private Double timeSpent;
    private Long wordId;

    @Builder
    public PoemSaveRequestDto(String content, Double timeSpent, Long wordId) {
        this.content = content;
        this.timeSpent = timeSpent;
        this.wordId = wordId;
    }
}
