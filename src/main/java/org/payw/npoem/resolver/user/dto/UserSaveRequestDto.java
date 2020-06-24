package org.payw.npoem.resolver.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserSaveRequestDto {
    private String nickname;

    @Builder
    public UserSaveRequestDto(String nickname) {
        this.nickname = nickname;
    }
}
