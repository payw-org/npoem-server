package com.payw.npoem.resolver.entry.dto;

import com.payw.npoem.domain.entry.Poem;
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

    @Builder
    public PoemSaveRequestDto(String content, Integer spentTime) {
        this.content = content;
        this.spentTime = spentTime;
    }

    public Poem toEntity() {
        return Poem.builder()
                .content(content)
                .spentTime(spentTime)
                .build();
    }
}
