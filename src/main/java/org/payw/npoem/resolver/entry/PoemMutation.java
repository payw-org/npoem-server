package org.payw.npoem.resolver.entry;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;

import org.payw.npoem.config.security.JwtTokenProvider;
import org.payw.npoem.domain.user.User;
import org.payw.npoem.resolver.entry.dto.PoemSaveRequestDto;
import org.payw.npoem.service.entry.PoemService;

import lombok.RequiredArgsConstructor;

import org.payw.npoem.service.user.UserService;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class PoemMutation implements GraphQLMutationResolver {
    private final PoemService poemService;
    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;

    public Long writePoem(PoemSaveRequestDto requestDto) {
        Optional<User> user = userService.loadUserByNickname(jwtTokenProvider.getUserNickname(requestDto.getToken()));

        if (user.isPresent()) {
            return poemService.writePoem(user.get(), requestDto);
        } else {
            return (long) 0;
        }
    }
}
