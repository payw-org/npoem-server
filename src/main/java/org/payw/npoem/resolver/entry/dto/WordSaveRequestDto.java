package org.payw.npoem.resolver.entry.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class WordSaveRequestDto {
    private String text;

    @Builder
    public WordSaveRequestDto(String text) {
        this.text = text;
    }
}
