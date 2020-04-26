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
    private Long wordId;

    @Builder
    public PoemSaveRequestDto(String content, Integer spentTime, Long wordId) {
        this.content = content;
        this.spentTime = spentTime;
        this.wordId = wordId;
    }
}
