package org.payw.npoem.resolver.user;

import org.payw.npoem.config.security.JwtTokenProvider;
import org.payw.npoem.domain.user.User;
import org.payw.npoem.service.user.UserService;
import org.payw.npoem.resolver.user.dto.UserSaveRequestDto;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class UserMutation implements GraphQLMutationResolver {
    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;

    public String createUser(UserSaveRequestDto requestDto) {
        return jwtTokenProvider.createToken(userService.createUser(requestDto).getNickname());
    }

    public String updateNickname(String token, String nickname) {
        Optional<User> user = userService.loadUserByNickname(jwtTokenProvider.getUserNickname(token));

        if(user.isPresent()) {
            return userService.updateNickname(user.get(), nickname);
        }
        else {
            return "user not found";
        }
    }
}
